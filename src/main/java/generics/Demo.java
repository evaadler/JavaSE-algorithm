package generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        ParameterizedType type = (ParameterizedType) Bar.class.getGenericSuperclass();
        System.out.println(type.getActualTypeArguments()[0]);

        ParameterizedType fieldType = (ParameterizedType)Foo.class
                .getField("children").getGenericType();
        System.out.println(fieldType.getActualTypeArguments()[0]);

        ParameterizedType paramType = (ParameterizedType)Foo.class
                .getMethod("foo", List.class).getGenericParameterTypes()[0];
        System.out.println(paramType.getActualTypeArguments()[0]);
        System.out.println(Foo.class.getTypeParameters()[0].getBounds()[0]);

    }
}

class Foo<T extends CharSequence> {
    public List<Bar> children = new ArrayList<Bar>();

    public List<StringBuilder> foo(List<String> foo){
        return null;
    }

    public void bar(List<? extends String> param) {
        // empty
    }
}

class Bar extends Foo<String>{}

