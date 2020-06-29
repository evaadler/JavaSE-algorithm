package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeData
 *
 * @author Alicia
 * @description
 * @date 2020/6/20
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001, "马化腾", 34, 6000.38, Employee.Status.BUSY));
        list.add(new Employee(1002, "马云", 12, 9876.12, Employee.Status.FREE));
        list.add(new Employee(1003, "刘强东", 33, 3000.82, Employee.Status.VOCATION));
        list.add(new Employee(1004, "雷军", 26, 7657.37, Employee.Status.BUSY));
        list.add(new Employee(1005, "李彦宏", 65, 5555.32, Employee.Status.BUSY));
        list.add(new Employee(1006, "比尔盖茨", 42, 9500.43, Employee.Status.FREE));
        list.add(new Employee(1007, "任正非", 26, 4333.32, Employee.Status.FREE));
        list.add(new Employee(1008, "扎克伯格", 35, 2500.32, Employee.Status.BUSY));

        return list;
    }
}
