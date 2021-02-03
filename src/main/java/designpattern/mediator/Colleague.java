package designpattern.mediator;

/**
 * Colleague
 *
 * @author Alicia
 * @description
 * @date 2021/2/2
 */
public abstract class Colleague {
    private Mediator mediator;
    private String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator(){
        return null;
    }

    public String getName(){
        return name;
    }

    public abstract void sendMessage(int stateChange);

    public abstract void startCoffee();

    public abstract void stopTv();
}
