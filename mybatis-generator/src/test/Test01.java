package test;

import dao.UserMapper;
import entity.User;
import entity.UserExample;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-31-22:56
 * Description：<描述>
 */
public class Test01 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();

            /**
             * 增删改
             */
            UserMapper userMapper = session.getMapper(UserMapper.class);

            User user = new User();
            user.setId(1003);
            user.setUsername("wojiu");
            user.setPassword("gcagca");
            user.setPhone("21313231");
            //user.setAddress("东晋");
            //userMapper.insert(user);

            //动态SQL，不穿的值不会有值
            //userMapper.insertSelective(user);

            //UPDATE 根据主键更新  动态SQL
            //userMapper.updateByPrimaryKeySelective(user);

            //userMapper.deleteByPrimaryKey(1002);

            //查询
            //User user1 = userMapper.selectByPrimaryKey(1003);
            //System.out.println(user1);

            UserExample userExample= new UserExample();
            //userExample.or().andUsernameEqualTo("qqq")
            //                .andPasswordEqualTo("11111");

            userExample.or().andUsernameLike("汤姆")
                            .andIdGreaterThan(1);   //ID大于1
            //或者  地址等于南京
            userExample.or().andAddressEqualTo("南京");

            List<User> users = userMapper.selectByExample(userExample);
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
