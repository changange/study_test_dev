package cakes.mock.util;

import cakes.mock.model.MockConfig;
import cn.hutool.core.io.IoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author：耿常安
 * Date：2021-03-28-10:33
 * Description： 工具类
 * 读取yml
 *       1
 */
public final class YmlUtils {

    public static void main(String[] args) {
    //    MockConfig mockConfig = parseMockConfig("E:\\mock-03\\create-account.yml");
    //    System.out.println(mockConfig);
    }

    private static ObjectMapper MAPPER;

    private YmlUtils(){

    }

    static {
        MAPPER = new ObjectMapper(new YAMLFactory());
        //MAPPER = new ObjectMapper(new YAMLFactory(.configure()));
    }

    public static MockConfig parseMockConfig(File file){
        try {
            FileInputStream stream = IoUtil.toStream(file);
            return MAPPER.readValue(stream, MockConfig.class);
            // return MAPPER.readValue(stream, MockContext.class);
        } catch (IOException e) {
            System.out.println("yml failed--" + file);
            throw new IllegalStateException("read yml failed.",e);
        }
    }
}
