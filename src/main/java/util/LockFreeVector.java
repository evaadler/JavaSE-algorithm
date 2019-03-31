package util;

import java.util.AbstractList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 无锁 Vector 实现
 * @param <E>
 */
public class LockFreeVector<E>  extends AbstractList<E>{

    private static final boolean debug = false;

    /**
     * Size of the first bucket. sizeof(bucket[i+1]) = 2*sizeof(bucket[i])
     */
    private static final int FIRST_BUCKET_SIZE = 8;

    /**
     * number of buckets. 30 will allow 8*(2^30-1) elements
     */
    private static final int N_BUCKET = 30;


    /**
     * We will have at most N_BUCKET number of buckets, And we have
     * sizeof(buckets.get(i))-FIRST_BUCKET_SIZE**(i+1)
     */
    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;

    static class WriteDescriptor<E> {
        public E oldV;
        public E newV;
        public AtomicReferenceArray<E> addr;
        public int addr_ind;

        /**
         * Creating a new descriptor
         * @param addr Operator address
         * @param addr_ind Index of address
         * @param oldV old operand
         * @param newV new operand
         */
        public WriteDescriptor(AtomicReferenceArray<E> addr, int addr_ind,
                               E oldV, E newV){
            this.addr = addr;
            this.addr_ind = addr_ind;
            this.oldV = oldV;
            this.newV = newV;

        }

        /**
         * Set newV
         */
        public void doIt(){
            addr.compareAndSet(addr_ind, oldV, newV);
        }
    }

    static class Descriptor<E> {
        public int size;
        volatile  WriteDescriptor<E> writeop;

        /**
         *
         * @param size Size of the vector
         * @param writeop Executor write operation
         */
        public Descriptor(int size, WriteDescriptor<E> writeop) {
            this.size = size;
            this.writeop = writeop;
        }

        public void completeWrite() {
            WriteDescriptor<E> tmpOp = writeop;

            if (tmpOp != null) {
                tmpOp.doIt();
                writeop = null; // this is safe since all to writeop use
                // null as r_value
            }
        }
    }

    private AtomicReference<Descriptor<E>> descriptor;

    private static final int zeroNumFirst = Integer.
            numberOfLeadingZeros(FIRST_BUCKET_SIZE);

    public LockFreeVector(){
        buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>(N_BUCKET);
        buckets.set(0, new AtomicReferenceArray<E>(FIRST_BUCKET_SIZE));
        descriptor = new AtomicReference<Descriptor<E>>(new Descriptor<E>(0,null));



    }

    /**
     * add e at the end of vector
     * @param e
     */
    public void push_back(E e) {
       Descriptor<E> desc;
       Descriptor<E> newd;

       do {
           desc = descriptor.get();
           desc.completeWrite();

           //desc.size : 当前vector大小
           int pos = desc.size + FIRST_BUCKET_SIZE;
           int zeroNumPos = Integer.numberOfLeadingZeros(pos);
           int bucketInd = zeroNumFirst - zeroNumPos;
           if (buckets.get(bucketInd) == null) {
               int newLen = 2 * buckets.get(bucketInd - 1).length();
               if (debug) {
                   System.out.println("New length is:" + newLen);
               }
               buckets.compareAndSet(bucketInd, null, new AtomicReferenceArray<E>(newLen));
           }

           int idx = (0x80000000>>>zeroNumPos) ^ pos;
           newd = new Descriptor<>(desc.size + 1, new WriteDescriptor<E>(
                   buckets.get(bucketInd), idx, null, e
           ));

       } while (!descriptor.compareAndSet(desc, newd));
        // 重复做没有关系，因为是原子操作
       descriptor.get().completeWrite();
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
