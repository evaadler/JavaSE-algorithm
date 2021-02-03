package designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * InfoCollege
 *
 * @author Alicia
 * @description
 * @date 2021/2/1
 */
public class InfoCollege implements College {
    private List<Department> departmentList;
    private int index;

    public InfoCollege(){
        departmentList = new LinkedList<>();
        addDeparment("信息安全专业", "信息安全专业");
        addDeparment("网络安全专业", "网络安全专业");
        addDeparment("服务器安全专业", "服务器安全专业");
    }



    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public Department addDeparment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department );
        return department;
    }

    @Override
    public Iterator createIterator() {
        return new InfoIterator();
    }
}
