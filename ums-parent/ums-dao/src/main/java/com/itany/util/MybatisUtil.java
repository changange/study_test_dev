package com.itany.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Author：耿常安
 * Date：2021-02-01-13:19
 * Description：<描述>
 */
public class MybatisUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    static {
        factory=new SqlSessionFactoryBuilder().build(MybatisUtil.class.getClassLoader().getResourceAsStream
                ("mybatis-config.xml"));

    }
    public static SqlSession getSession(){
        SqlSession session = local.get();
        if (session==null){
            session = factory.openSession();
            local.set(session);
        }
        return session;
    }

    public static void closeSession(){
        SqlSession sqlSession = local.get();
        local.set(null);
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
