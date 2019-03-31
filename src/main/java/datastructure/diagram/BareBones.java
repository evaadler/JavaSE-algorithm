package datastructure.diagram;

import datastructure.queue.Queue;
import util.In;
import util.SET;
import util.StdOut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fifi on 2017/5/6.
 */
public class BareBones {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();  // queue of website to crawl
        SET<String> discovered = new SET<String>();  // set of discovered websites

        // start crawling from root website
        String root = "http://www.princeton.com";
        queue.enqueue(root);
        discovered.add(root);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();

            StdOut.println(v);

            // read in raw html from next website in queue
            In in = new In(v);
            String input = in.readAll();

            /* use regular expressions to find all URLs in website of form http://xxx.yyy.zzz */
            String regexp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String w = matcher.group();
                if(!discovered.contains(w)) {
                    discovered.add(w);
                    queue.enqueue(w);
                }
            }
        }

    }
}
