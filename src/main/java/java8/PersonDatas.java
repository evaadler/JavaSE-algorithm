package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * PersonDatas
 *
 * @author Alicia
 * @description
 * @date 2021/12/12
 */
public class PersonDatas {
    public List<Person> getPersonList(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));
        return personList;
    }
}
