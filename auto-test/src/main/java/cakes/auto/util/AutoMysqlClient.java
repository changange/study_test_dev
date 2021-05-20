package cakes.auto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-04-02-8:24
 * Description：<描述>
 */
public class AutoMysqlClient {

    public static int insert(String sql, Map<String,Object> params){

        //JDBC操作
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("", "", "");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,"");
            preparedStatement.setObject(1,"");
            preparedStatement.setObject(1,"");

            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
        return -1;
    }
    public static int delete(String sql, Map<String,Object> params){

        return -1;
    }
    public static int update(String sql, Map<String,Object> params){

        return -1;
    }
    public static int select(String sql, Map<String,Object> params){

        return -1;
    }
}
