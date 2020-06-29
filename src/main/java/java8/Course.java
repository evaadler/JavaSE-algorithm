package java8;

import java.util.List;

/**
 * Course
 *
 * @author Alicia
 * @description
 * @date 2020/6/24
 */
public class Course {
    String name;
    List<Teacher> teachers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
