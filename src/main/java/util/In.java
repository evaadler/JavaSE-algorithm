package util;

import java.util.Scanner;

/**
 * Created by fifi on 2017/4/26.
 */
public class In {
    public In(String c) {
        Scanner scanner = new Scanner("tinyG.txt");



        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    public static void main(String[] args) {
        In in = new In("");

    }

    public String readAll() {
        return "";
    }
}


