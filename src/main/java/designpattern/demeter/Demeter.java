package designpattern.demeter;

import java8.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Demeter
 *
 * @author Alicia
 * @description
 * @date 2021/1/14
 */
public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

class SchoolManager{
    /**
     * 输出学校总部和学院员工信息
     * @param collegeManager
     */
    public void printAllEmployee(CollegeManager collegeManager) {
        List<CollegeEmployee> list= collegeManager.getAllEmployee();
        System.out.println("-------fifi的人--------");
        for(CollegeEmployee e: list){
            System.out.println(e.getId());
        }
        
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("-------fifi公司的人-------");
        for (Employee e:list2){
            System.out.println(e.getId());
        }
    }

    private List<Employee> getAllEmployee() {
            List<Employee> list = new ArrayList<>();
            for (int i=0; i<5; i++){
                Employee emp = new Employee();
                emp.setId(i);
                list.add(emp );

            }
            return list;
    }
}
class CollegeManager{

    public List<CollegeEmployee> getAllEmployee() {
        return null;
    }
}

class CollegeEmployee{
    private String id;
    
    public String getId() {
        return id;
    }
}
