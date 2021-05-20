package test;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-31-12:45
 * Description：<描述>
 */
public class Test05 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();

            UserDao userDao = session.getMapper(UserDao.class);

            User userParam = new User();
            userParam.setId(3);
            userParam.setUsername("奶牛11");
            userParam.setPassword("11111");
            userParam.setPhone("1231313123");
            userParam.setAddress("桃园");

            //if
            //List<User> users = userDao.selectByParams(userParam);
            //choose
            //List<User> users = userDao.selectByParams2(userParam);
            //System.out.println(users);

            //set
            //userDao.updateUser2(userParam);

            //trim 查询操作
            //List<User> users = userDao.selectByParams4(userParam);
            //System.out.println(users);

            //trim 跟新操作
            //userDao.updateUser3(userParam);

            //foreach
            List<User> users = userDao.selectByIds(Arrays.asList(2, 1, 3));
            System.out.println(users);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.close();
        }
    }
}
