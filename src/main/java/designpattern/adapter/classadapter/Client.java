package designpattern.adapter.classadapter;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/19
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 类适配器模式 ====");
        Phone phone = new Phone();
        new Phone().charging(new VoltageAdapter(new Voltage220V()));
    }
}
