package designpattern.command;

/**
 * LightOffCommand
 *
 * @author Alicia
 * @description
 * @date 2021/1/28
 */
public class LightOnCommand implements Command{
    LightReceiver light;

    public LightOnCommand(LightReceiver light){
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        // 调用接收者的方法
        light.off();
    }

    @Override
    public void undo() {
        // 调用接收者的方法
        light.on();
    }
}
