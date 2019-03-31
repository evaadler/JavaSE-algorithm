package generics;

import java.util.ArrayList;
import java.util.List;

public class Product<T> {
    /*
    private void func1(Object arg){
        if (arg instanceof T){}
    }

    private void func2(){
        T var = new T();
    }

    private void func3(){
        T[] vars = new T[3];
    }*/


    class Creater<T> {
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value){
            this.value = value;
        }
    }

    class StringCreater extends Creater<String> {

        @Override
        public void setValue(String value) {
            super.setValue(value);
        }

        @Override
        public String getValue() {
            return super.getValue();
        }
    }

    public static void main(String[] args) {

    }
}


