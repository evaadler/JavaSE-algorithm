package designpattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * ClientTest
 *
 * @author Alicia
 * @description
 * @date 2021/4/5
 */
public class ClientTest {
    public static void main(String[] args) throws Exception{
        String expStr = getExpStr();
        HashMap<String, Integer> var = getValue(expStr);
        Calculator calculator = new Calculator((expStr));
        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
    }

    public static String getExpStr() throws IOException{
        System.out.println("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static HashMap<String, Integer> getValue(String expStr) throws IOException{
        HashMap<String, Integer> map = new HashMap<>();

        for (char ch : expStr.toCharArray()){


        }

        return null;
    }
}
