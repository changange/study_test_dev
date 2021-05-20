package com.itany.Dao;

import com.itany.entity.ConnectInfo;
import com.itany.factory.LocalSqlSessionFactory;
import com.itany.mapper.BaseMapper;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.Function;

/**
 * Author：耿常安
 * Date：2021-03-12-11:03
 * Description：<描述>
 */
public class DaoFacede {

    //M extends BaseMapper  参数只能是继承自BaseMapper
    public static <R,M extends BaseMapper> R ofMapper(ConnectInfo connectInfo, Class<M> mapperClass, Function<M,R> func){
        SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connectInfo);
        M mapper = sqlSession.getMapper(mapperClass);
        R result = func.apply(mapper);
        return result;
    }


    //执行SQL
    public static void execSql(ConnectInfo connectInfo,String sql) {
        try {
            SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connectInfo);
            Connection connection = sqlSession.getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void execSql(ConnectInfo connectInfo, List<String> sqls){
        try(SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connectInfo);
            Connection connection = sqlSession.getConnection();
        ){
            for (String sql:sqls){
                try(PreparedStatement ps= connection.prepareStatement(sql)){
                    ps.executeUpdate();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getInfo(ConnectInfo connectInfo, String sql, String columnNmae){
        SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connectInfo);
        try(Connection connection = sqlSession.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery())
        {
            if (rs.next()){
                return rs.getString(columnNmae);
            }
            throw new IllegalStateException("query fialed");
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalStateException("query fialed");
        }
    }

    public static String getTableSql(ConnectInfo connectInfo,String dbName,String tableName){
        String sql = String.format("show create table `%s`.`%s`", dbName,tableName);
        return getInfo(connectInfo,sql,"create table ");
    }

    public static String getDBSql(ConnectInfo connectInfo,String dbName){
        String sql = String.format("show create database `%s`", dbName);
        return getInfo(connectInfo,sql,"create database ");
    }
}
