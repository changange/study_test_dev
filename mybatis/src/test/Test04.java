package test;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-31-10:38
 * Description：<描述>
 */
public class Test04 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            UserDao userDao = session.getMapper(UserDao.class);

            //User user = userDao.selectById2(1);
            //User user = userDao.selectById3(1);
            //System.out.println(user);

            //多参数查询   索引
            //User qqq = userDao.selectByUsernameAndPassword("qqq", "11111");

            //多参数查询    注解
            // User qqq = userDao.selectByUsernameAndPassword2("qqq", "11111");

            //多参数查询 封装为一个对象
            //User user = new User();
            //user.setUsername("qqq");
            //user.setPassword("11111");
            //User qqq = userDao.selectByUsernameAndPassword3(user);


            //多参数查询   传一个MAP集合
            //Map map = new HashMap<String, Object>();
            //map.put("username","qqq");
            //map.put("password","11111");
            //User user = userDao.selectByUsernameAndPassword4(map);
            //System.out.println(user);


            //模糊查询
            String username="q";
            //手动拼接
            //List<User> users = userDao.selectByUsername("%" + username + "%");
            //bind
            List<User> users = userDao.selectByUsername2(username);

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
