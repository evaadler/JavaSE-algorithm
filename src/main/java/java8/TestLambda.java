package java8;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * TestLambda
 *
 * @author Alicia
 * @description
 * @date 2020/6/21
 */
public class TestLambda {

    @Test
    public void test(){
        List<Employee> employees= EmployeeData.getEmployees();
        Collections.sort(employees, (x1, x2) -> {
            if (x1.getAge() == x2.getAge()){
                return x1.getName().compareTo(x2.getName());
            }else {
                return x1.getAge()-x2.getAge();
            }
        });
    }

    public String handleStr(String str, CutomFunctionalInterface toBigger){
        return toBigger.getValue(str);
    }

    @Test
    public void test2(){
       String str1 =  handleStr("fiejfieBB", str -> str.toUpperCase());
        System.out.println(str1);
        String str2 = handleStr("str1", str -> str.substring(2, 5));
        System.out.println(str2);
    }

    public void calculate(Long n1, Long n2, TwoParamsFunctional<Long, Long> functional){
        System.out.println(functional.process(n1, n2));
    }

    @Test
    public void test3() {
        calculate(34L, 23L, (n1, n2)->(n1+n2));
    }
}
