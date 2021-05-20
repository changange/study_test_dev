package com.atany.gca.day07.Spring.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Author：耿常安
 * Date：2021-02-27-22:15
 * Description：<描述>
 */
public class HelloFactory {
    public static HelloService getHeiiloService(Class cls) throws Exception {
        //1、获取接口的全类名
        String interfaceName = cls.getName();
        //2、加载配置文件
        Properties prop = new Properties();
        File file = new File("E:\\bt\\code\\hello.properties");
        //3、通过配置文件  获取对应的实现类的 全类名
        prop.load(new FileInputStream(file));
        String impleName = prop.getProperty(interfaceName);
        //4、获取实现类的CLASS
        Class implCls= Class.forName(impleName);
        //5、获取实例
        Object obj = implCls.newInstance();
        if(obj instanceof HelloFactory){
            return (HelloService) obj;
        }
        return new HelloServiceImpl();
    }
}
