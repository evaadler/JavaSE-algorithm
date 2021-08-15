//package designpattern.mediator;
//
///**
// * Alarm
// *
// * @author Alicia
// * @description
// * @date 2021/2/2
// */
//public class Alarm extends Colleague {
//    // 构造器
//    public Alarm(Mediator mediator, String name){
//        super(mediator, name);
//        // 在创建Alarm同事对象时，将自己放入到ConcreteMediator 对象
//        mediator.register(name, this);
//    }
//
//    @Override
//    public void sendMessage(int stateChange) {
//        // 调用中介者对象的getMessage
//        this.getMediator().getMessage(stateChange, this.getName());
//    }
//
//    public void sendAlarm(int stateChange){
//        sendMessage(stateChange);
//    }
//}
