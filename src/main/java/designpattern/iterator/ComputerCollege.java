package designpattern.iterator;

import java.util.Iterator;

/**
 * ComputerCollege
 *
 * @author Alicia
 * @description
 * @date 2021/2/1
 */
public class ComputerCollege implements College{
    private Department[] departments;
    private int numOfDepartment = 0;

    public ComputerCollege(){
        departments = new Department[5];
        addDeparment("java", "java专业");
        addDeparment("php", "php");
        addDeparment("大数据", "大数据专业");
    }
    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public Department addDeparment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment++;
        return department;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerIterator(departments);
    }

}
