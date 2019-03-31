package huawei;

import com.sun.tools.javac.util.ArrayUtils;
import sun.text.resources.lt.CollationData_lt;


import java.util.*;

/**
 * Created by fifi on 2017/5/16.
 */
public class Main {

    /**
     * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，
     * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     */
    public static void readMap(){

        Scanner sc = new Scanner(System.in);
        //while (sc.hasNext()) {
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int s=sc.nextInt();
                int value=sc.nextInt();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + value);
                } else{
                    map.put(s, value);
                }
            }
            for (Integer key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        //}

    }

    public static void reverseInt(){
        Scanner scanner = new Scanner(System.in);
        int divideNumber = 10;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            String ret = "";
            while (n / divideNumber > 0) {
                int num = n % divideNumber;
                if (!ret.contains(num + "")) {
                    ret += num;}
                    n /= divideNumber;


            }

            if (!ret.contains(n+"")) {
                ret += n;
            }
            System.out.println(ret);
        }
    }

    /**
     * 字符个数统计
     */
    public static void countNum(){
        Scanner scanner = new Scanner(System.in);
        int[] number = new int[128];
        while (scanner.hasNext()){
            String n = scanner.nextLine();
            int count = 0;

            for (char c : n.toCharArray()){
                int num = c;
                if (num <= 127 && number[num] == 0) {
                    number[num] = 1;
                    count ++;
                }
            }
            System.out.println(count);
        }

    }

    public static void reverseStr(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> list = Arrays.asList(String.valueOf(n).split(""));
            Collections.reverse(list);
            String str = "";
            for (String s : list){
                str += s;
            }
            System.out.println(str);
        }
    }

    public static void reverseByStr(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String n = scanner.nextLine();
            List<String> list = Arrays.asList(String.valueOf(n).split(""));
            Collections.reverse(list);
            String str = "";
            for (String s : list){
                str += s;
            }
            System.out.println(str);
        }
    }

    /**
     * 句子逆序
     */
    public static void reverse(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            Collections.reverse(Arrays.asList(strs));
            String sen = "";
            for (String s : strs){
                sen += s+" ";
            }
            System.out.println(sen);
        }
    }

    /**
     * 按字典排序
     */
    public static void sortByDic(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[n];
        for (int i=0; i<n; i++){
            strs[i] = scanner.nextLine();
        }

        Collections.sort(Arrays.asList(strs));

        for (String s : strs){
            System.out.println(s);
        }

    }

    /**
     * 坐标计算
     */
    public static void calCoord(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] coords = str.split(";");

        int x=0 , y = 0;
        for (String s : coords){
            int l = s.length();
            if (l!=3 && l!=2 ){ continue;}
            if (s.charAt(s.length()-1)>'9'){continue;}
            char first = s.charAt(0);

            int len = 0;
            if (l == 3){
                len = Integer.parseInt(s.substring(1,3));}
            else if (l == 2){
                len = Integer.parseInt(s.substring(1,2));}
            if (first == 'A') {x -= len;}
            else if (first == 'D') {x += len;}
            else if (first == 'W') {y += len;}
            else if (first == 'S') {y -= len;}

        }
        System.out.printf("%d,%d",x,y);
    }


    public static void main(String[] args) {
        calCoord();
    }
}
