package com.itany.factory;

import com.itany.entity.ConnectInfo;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * Author：耿常安
 * Date：2021-03-12-11:07
 * Description：<描述>
 */
public class LocalSqlSessionFactory {

    private LocalSqlSessionFactory(){

    }

    private static class ClassHolder{
        private static final LocalSqlSessionFactory INSTANCE=new LocalSqlSessionFactory();
    }

    public static LocalSqlSessionFactory of(){
        return ClassHolder.INSTANCE;
    }

    public SqlSession getSqlSession(ConnectInfo connectInfo){
        //自己构建一个configuration  mybatis里边也是先读一个xml流，再把流分装成一个configuration
        Configuration configuration = new Configuration();

        //驼峰对应字段
        //<settings>
        //<setting name="mapUnderscoreToCamelCase" value="true"/>       XXXXXXXXXXXX啥意思
        //</settings>
        configuration.setMapUnderscoreToCamelCase(true);

        //环境    id随便写
        Environment environment = new Environment.Builder("sync")
                //这里边就有连接池了
                .dataSource(LocalDataSourceFactory.getPooledDataSource(connectInfo))
                .transactionFactory(new JdbcTransactionFactory())   //数据源是jdbc的
                .build();


        //configuration就是xml配置文件里边的最大的标签configuration
        configuration.setEnvironment(environment);
        configuration.addMappers("com.itany.mapper");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }
}
