package cakes.auto.SDK;

import cakes.auto.util.AutoMysqlClient;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-04-02-8:47
 * Description：<描述>
 */
public class PayMysqlSdk {
    public static boolean addPayDetail(){
        String sql = "insert into pay_detail ('pay_id','user_id' ) value(??)";
        //
        Map<String, Object> params = Maps.newHashMap();
        AutoMysqlClient.insert("",params);

        int ret = AutoMysqlClient.insert(sql, params);

        return true;
    }
}
