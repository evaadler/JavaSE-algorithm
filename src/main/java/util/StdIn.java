package util;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by fifi on 2017/5/9.
 */
public class StdIn {

    static Scanner scan;

    static {
            scan = new Scanner(System.in);
    }

    public static boolean hasNextLine() {

        return scan.hasNextLine();
    }

    public static String readLine() {
        return scan.nextLine();
    }

    public static int readInt() {
        return scan.nextInt();
    }

    public static boolean isEmpty() {
        return !scan.hasNext();
    }

    public static void main(String[] args) {
        System.out.println(StdIn.readInt());
    }
}
