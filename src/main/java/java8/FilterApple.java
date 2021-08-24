package java8;


import sun.java2d.loops.GraphicsPrimitive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FilterApple
 *
 * @author Alicia
 * @description
 * @date 2021/8/22
 */
public class FilterApple {
    public static void main(String[] args) throws Exception{
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));
        List<Apple> result = findApple(list, new GreenAnd150WeightFilter());
        System.out.println(result);

        List<Apple> lambdaResult = findApple(list, (apple) -> {
            return apple.getColor().equals("green");
        });

        System.out.println(lambdaResult);

        List<Apple> yellowApples = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });
        System.out.println(yellowApples);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();

        //Thread.currentThread().join();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

    }

    @FunctionalInterface//只有一个方法的时候可以写这个注解
    public interface AppleFilter{
        /**
         * 过滤条件
         * @param apple apple
         * @return boolean
         */
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter){
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples){
            if (appleFilter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd150WeightFilter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return ("green".equals(apple.getColor()) && apple.getWidth()>=160);
        }
    }

}


