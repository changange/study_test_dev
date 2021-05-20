package test;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

/**
 * Author：耿常安
 * Date：2021-01-30-16:36
 * Description：<描述>
 */
public class Test02 {

    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();

            User user = new User();
            user.setUsername("秋香");
            user.setPassword("11111");
            user.setPhone("1231313123");
            user.setAddress("官方");

            UserDao userDao = session.getMapper(UserDao.class);
            System.out.println("添加前："+user);
            userDao.insert(user);
            //userDao.insertUser(user);     //没有返回值
            System.out.println("添加后："+user);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.close();
        }
    }
}
