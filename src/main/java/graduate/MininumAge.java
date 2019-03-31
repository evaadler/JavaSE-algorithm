package graduate;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 职工有职工号，姓名，年龄.输入n个职工的信息，找出3个年龄最小的职工打印出来。
 *
 * Created by fifi on 2017/6/13.
 */
public class MininumAge {

    public void mininum(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] empNos = new int[N];
        String[] names = new String[N];
        int[] ages = new int[N];
        HashMap<Integer, HashMap<Integer, String>> emps= new HashMap<>();
        int i = 0;
        while (scanner.hasNextLine()){
            //empNos[i] = scanner.nextInt();
            //names[i] = scanner.next();
            //ages[i] = scanner.nextInt();
            //emps.put()
            i++;

        }

    }

    public static void main(String[] args) {

    }
}
