import java.util.ArrayList;
import java.util.List;

public class 自除数 {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> lists = new ArrayList<>();

        int tmp = 0;

        for (int i = left; i<=right; i++){

            tmp = i;

            while(tmp / 10 >0){
                int num = tmp / 10;
                if(tmp % num == 0){
                    tmp = tmp / 10;
                }else{
                    break;
                }
            }

            if (tmp == 0){
                lists.add(i);
            }else if(tmp < 10){
                lists.add(i);
            }else if(tmp > 10){

            }
        }

        return lists;
    }
}
