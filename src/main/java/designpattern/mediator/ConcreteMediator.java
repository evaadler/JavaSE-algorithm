package designpattern.mediator;

import designpattern.decorator.Coffee;

import java.util.HashMap;

/**
 * ConcreteMediator
 *
 * @author Alicia
 * @description
 * @date 2021/2/3
 */
public class ConcreteMediator extends Mediator {
// 放入所有的同时对象
    private HashMap<String ,Colleague> colleagueMap;
    private HashMap<String, String> interMap;

    public ConcreteMediator(){
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueMap.get(colleagueName) instanceof Alarm){
            if (stateChange == 0){
                ((CoffeeManchine)(colleagueMap.get(interMap.get("CoffeeMachine")))).startCoffee();
                ((TV)(colleagueMap.get(interMap.get("TV")))).stopTv();
            } else if (stateChange == 1){

            }
        }
    }

    @Override
    public void register(String name, Colleague colleague) {
        colleagueMap.put(name, colleague);


        if (colleague instanceof Alarm) {
            interMap.put("Alarm", name);
        }else if (colleague instanceof CoffeeManchine){
            interMap.put("CoffeeMachine", name);
        }else if (colleague instanceof TV){

        }else if (colleague instanceof Curtains){

        }
    }

    @Override
    public void sendMessage() {

    }
}
