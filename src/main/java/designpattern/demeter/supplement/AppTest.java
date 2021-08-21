package designpattern.demeter.supplement;


/**
 * AppTest
 *
 * @author Alicia
 * @description
 * @date 2021/8/21
 */
public class AppTest {
    public String f1(){
        String s = new String();

        Foo f = new Foo();
        Bar bar = f.get();//这个Bar就不是朋友

        return s;
    }
}

class Foo{
    public Bar get(){
        return new Bar();
    }
}

class Bar{

}
