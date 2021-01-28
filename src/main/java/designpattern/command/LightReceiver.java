package designpattern.command;

import java.io.OutputStream;

/**
 * LightReceiver
 *
 * @author Alicia
 * @description
 * @date 2021/1/28
 */
public class LightReceiver {

    public void on(){
        System.out.println("电灯打开了");
    }

    public void off(){
        System.out.println("电灯关闭了");
    }
}
