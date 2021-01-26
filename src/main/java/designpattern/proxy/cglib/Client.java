package designpattern.proxy.cglib;

import designpattern.proxy.ITeacherDao;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/26
 */
public class Client {

    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDao teacherDao1 = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        teacherDao1.teach();
    }
}
