package test;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Author：耿常安
 * Date：2021-01-29-19:41
 * Description：<描述>
 */
public class Test01 {
    public static void main(String[] args) {
        /**
         * 创建一个SqlSession，成为持久化管理器，是mybatis的核心
         */
        // SqlSessionFactoryBuilder     工厂的构造器
        // SqlSessionFactory            工厂
        // SqlSession       会话
        //上边一步一步的创建

        //1、创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //2、创建      SqlSessionFactory
        SqlSessionFactory factory = builder.build(Test01.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
        //3、创建SqlSession
        SqlSession session = factory.openSession();

        //查看数据库的连接
        //Configuration conn = session.getConfiguration();
        //System.out.println(conn);

        User user = new User();
        user.setUsername("jack");
        user.setPassword("123");
        user.setPhone("1231");
        user.setAddress("深圳");
        /**
         * 插入操作
         * 方式1、纯配置文件的方式，没有接口
         * 直接读取mapper该文件
         */
        //session.insert("aaa.insertUser", user); //参数1：当前调用的方法，值为namespace.id，参数2：方法的实参

        /**
         * 方式2：配置文件—+接口
         * 通过代理自动生成DAO的实现类
         */
        UserDao userDao= session.getMapper(UserDao.class);  //参数为接口的class对象
        System.out.println(userDao);    //代理对象
        userDao.insertUser(user);


        session.commit();   //提交事务
    }
}
