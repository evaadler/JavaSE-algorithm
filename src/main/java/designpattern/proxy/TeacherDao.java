package designpattern.proxy;

/**
 * TeacherDao
 *
 * @author Alicia
 * @description
 * @date 2021/1/26
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("目标对象的teach方法");
    }
}
