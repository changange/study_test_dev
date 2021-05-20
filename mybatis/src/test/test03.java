package test;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-30-22:21
 * Description：<描述>
 */
public class test03 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            UserDao userDao=session.getMapper(UserDao.class);

            //User user = new User();
            //user.setId(4);
            //user.setUsername("汤姆");
            //user.setPassword("22222");
            //user.setPhone("999999");
            //user.setAddress("打通");
            //userDao.updateUser(user);

            //删除
            //userDao.deleteById(2);

            //查询
            User user = userDao.selectById(3);
            System.out.println(user);

            List<User> user1 = userDao.selectAll();
            System.out.println(user1);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.close();
        }
    }

}
