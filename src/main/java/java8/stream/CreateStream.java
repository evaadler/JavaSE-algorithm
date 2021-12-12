package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * CreateStream
 *
 * @author Alicia
 * @description
 * @date 2021/9/1
 */
public class CreateStream {
    public static void main(String[] args) {
        //createStreamFromIterator().forEach().;
        createObjStreamFromGenerate().forEach(System.out::println);
    }

    private static Stream<String>   createStreamFromCollectioin(){
        List<String> list = Arrays.asList("hello","world");
        return list.stream();
    }

    private static Stream<String> createStreamFromValues(){
        return Stream.of("hello", "world");
    }

    private static Stream<String> createStreamFromArrays(){
        String[] strings = {"hello", "alex"};
        return Arrays.stream(strings);
    }

    private static Stream<Integer> createStreamFromIterator(){
        Stream<Integer> stream = Stream.iterate(0, n->n+2);
        return stream;
    }

    private static Stream<Double> createStreamFromGenerate(){
        return Stream.generate(Math::random).limit(10);
    }

    private static Stream<Obj> createObjStreamFromGenerate(){
        return Stream.generate(new ObjSupplier()).limit(10);
    }

    static class ObjSupplier implements Supplier<Obj>{
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index, "Name->" + index);
        }
    }

    static class Obj{
        private final int id;
        private final String name;

        public Obj(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId(){
            return id;
        }

        public String getName(){
            return name;
        }
    }
}
