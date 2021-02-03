package designpattern.mediator;

/**
 * Curtains
 *
 * @author Alicia
 * @description
 * @date 2021/2/3
 */
public class Curtains extends Colleague {
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.getName());
    }

    public void upCurtains(){
        System.out.println("I am holding UpCurtains");
    }
}
