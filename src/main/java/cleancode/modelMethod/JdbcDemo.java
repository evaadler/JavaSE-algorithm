package cleancode.modelMethod;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.sql.*;

/**
 * JdbcDemo
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class JdbcDemo {
    public User queryUser(long id){
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "", "");

            // 2. 创建statement类对象，用来执行SQL语句
            stmt = conn.createStatement();

            // 3. ResultSet类，用来存放获取的结果集
            String sql = "select * from user where id=" + id;
            ResultSet resultSet = stmt.executeQuery(sql);

            String eid = null, ename = null, price = null;

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setTelephone(resultSet.getString("telephone"));
                return user;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}