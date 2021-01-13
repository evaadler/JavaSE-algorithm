package designpattern.inversion;

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
    }
}
//方案1
class Email{
    public String getInfo(){
        return "电子邮件信息：hello，fifi";
    }

}


class Person{

    public void receive(Email email){
        System.out.println(email.getInfo());
    }

}
