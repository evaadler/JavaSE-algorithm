package algorithms;

/**
 *
 * Created by fifi on 2017/4/15.
 */
public class RandNumber {

    private int rand1To5() {
        return (int) (Math.random() * 5)+1;
    }

    /**
     * 提供等概率产生1到5的函数rand1To5，根据此函数获得rand1To7
     * @return
     */
    public int rand1To7() {
        int num = 0;
        do {
            num = (rand1To5() - 1) * 5 + (rand1To5() - 1); // 插空
        }while (num > 20); // 筛选
        return num % 7 + 1;
    }

    public int rand01p() {
        // 可随意改变p
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    public void test() {
        int[] h = {2,3,1,7};

    }
}
