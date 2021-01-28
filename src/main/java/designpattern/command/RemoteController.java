package designpattern.command;

/**
 * RemoteController
 *
 * @author Alicia
 * @description
 * @date 2021/1/28
 */
public class RemoteController {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteController(){
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i=0; i<5; i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }



    // 按下开按钮
    public void onButtonWasPushed(int no){
        // 找到你按下的开的按钮，并到调用对应方法
        onCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    // 按下关按钮
    public void offButtonWasPushed(int no){
        // 找到你按下的关的按钮，并调用对应方法
        offCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }

    public void undoButtonWasPushed(){
        undoCommand.undo();
    }

    public void setCommand(int no, LightOnCommand lightOnCommand, LightOffCommand lightOffCommand) {

                onCommands[no] = lightOnCommand;
                offCommands[no] = lightOffCommand;


    }
}
