package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Info> list = new ArrayList<Info>();
        list.add(new Info("珠海", 0756));
        list.add(new Info("小渔村", 0756));

        Collections.sort(list);

        Info info = new Info("小渔村", 0756);

        int index1 = list.indexOf(info);
        int index2 = Collections.binarySearch(list, info);

        System.out.println("index1="+index1+", index2="+index2);
    }
}

class Info implements Comparable<Info>{
    public String name;
    public int age;

    public Info(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Info o) {
        return o.name.compareTo(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Info)obj).age == this.age;
    }
}
