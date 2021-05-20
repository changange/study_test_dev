package cakes.auto.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-28-10:33
 * Description： 工具类
 * 读取yml
 *       1
 */
public final class YmlUtils {

    public static void main(String[] args) {
        List<Map<String, Object>> list = parse("data/test-data.yml");
        System.out.println("List = " + list);
    }

    private static ObjectMapper MAPPER;

    private YmlUtils(){

    }

    static {
        MAPPER = new ObjectMapper(new YAMLFactory());
        //MAPPER = new ObjectMapper(new YAMLFactory(.configure()));
    }

    public static List<Map<String,Object>> parse(String path){
        try {
            InputStream inputStream = Resources.getResource(path).openStream();//路径转换成流
            //TypeReference：泛型反序列化
            return MAPPER.readValue(inputStream, new TypeReference<List<Map<String,Object>>>() {
            });
        } catch (IOException e) {
            throw new IllegalStateException("read ymlfailed.",e);
        }
    }

    ////测试的假数据
    //public static List<Map<String,Object>> parse(String path){
    //    Map<String, Object> data1 = Maps.newHashMap();
    //    OrderDetail orderDetail = new OrderDetail(5678,"anan",1207L);
    //    AccountInfo accountInfo = new AccountInfo("大帅哥","NNN");
    //    data1.put("orderDetail",orderDetail);
    //    data1.put("accountInfo",accountInfo);
    //
    //    Map<String, Object> data2 = Maps.newHashMap();
    //    OrderDetail orderDetail2 = new OrderDetail(1234,"gca",1207L);
    //    AccountInfo accountInfo2 = new AccountInfo("abc","VVV");
    //    data2.put("accountInfo",accountInfo2);
    //    data2.put("orderDetail",orderDetail2);
    //
    //    //TODO 数据读取
    //    return Lists.newArrayList(data1, data2);
    //}
}
