package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Author：耿常安
 * Date：2021-01-30-16:38
 * Description：<描述>
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();     //线程单例
    static {
        try {
            factory = new SqlSessionFactoryBuilder()
                    .build(
                            MyBatisUtil.class.getClassLoader()
                            .getResourceAsStream("mybatis-config.xml")
                    );
        } catch (Exception e) {
            throw new ExceptionInInitializerError("MyBatista初始化失败"+e.getMessage());
        }
    }

    public static SqlSession getSession(){
        SqlSession session = local.get();

        if (session==null){
            session = factory.openSession();
            local.set(session);
        }
        return session;
    }

    public static void close(){
        SqlSession session = local.get();
        if (session!=null){
            session.close();    //关闭
            local.remove();     //清空
        }
    }
}
