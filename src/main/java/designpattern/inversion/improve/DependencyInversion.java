package designpattern.inversion.improve;

/**
 * DependencyInversion
 *
 * @author Alicia
 * @description
 * @date 2021/1/13
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Wechat());
    }
}


class Email implements IReceiver{

    @Override
    public String getInfo(){
        return "电子邮件信息：hello，fifi";
    }

}

class Wechat implements IReceiver{

    @Override
    public String getInfo() {
        return "微信信息：在嘛？";
    }
}


// 方案2
class Person{
    // 是对接口的依赖
    public void receive(IReceiver email){
        System.out.println(email.getInfo());
    }

}

interface IReceiver{
    public String getInfo();
}
