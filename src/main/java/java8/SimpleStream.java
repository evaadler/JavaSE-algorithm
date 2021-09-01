package java8;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * SimpleStream
 *
 * @author Alicia
 * @description
 * @date 2021/9/1
 */
public class SimpleStream {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.OTHER),
                new Dish("salmon", false, 450, Dish.Type.OTHER)
        );

        List<String> dishNamesByCollections = getDishNamesByCollection(menu);
        System.out.println(dishNamesByCollections);

        List<String> dishNamesByCollections2 = getDishNamesByStream(menu);
        System.out.println(dishNamesByCollections2);
    }

    //stream方式取菜单名字
    private static List<String> getDishNamesByStream(List<Dish> menu){
//        List<String> menu = menu.stream().filter(d -> d.getCalories()<400)
//                .sorted(Comparator.comparing(Dish::getCalories))
//                .map(Dish::getName)
//                .collect(toList());

        return menu.stream().filter(d -> d.getCalories()<400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }


    // 传统方式取菜单名字
    private static List<String> getDishNamesByCollection(List<Dish> menu){
        List<Dish> lowCalories = new ArrayList<>();
        for (Dish d: menu){
            if(d.getCalories() < 400){
                lowCalories.add(d);
            }
        }
        //Comparator.comparing(Dish::getCalories);
        //sort
        lowCalories.sort((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));
        List<String> dishNamesList = new ArrayList<>();
        for (Dish d: lowCalories){
            dishNamesList.add(d.getName());
        }
        return dishNamesList;
    }
}
