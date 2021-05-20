package cakes.mock.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;


/**
 * Author：耿常安
 * Date：2021-04-02-21:47
 * Description：
 *
 * 在级短时间内实现一个mock能力
 * 对 SpringBoot的基本使用，对文件的基本使用。如何与需求结合，做技术实现的抽象
 * 做技术实现的抽象（大厂认为你是有潜力的）
 */
//运行的时候需要取消这个注释
// @RestController
public class MockDemoController {

    private static final String BASE_PATH="E:\\mock-03";

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/**")
    public String doMock(){
        String requestURI = httpServletRequest.getRequestURI();

        File basePath = new File(BASE_PATH);
        //获取文件夹下的问价列表
        File[] files = basePath.listFiles();
        if (Objects.isNull(files) || files.length == 0) {
            return "none mock data found";
        }

        requestURI = StringUtils.substringAfter(requestURI,"/");
        String fileName = requestURI.replace("/","-");

        for(File file:files){
            if(file.getName().equals(fileName + ".mock")){
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    String line = null;
                    StringBuilder builder = new StringBuilder();
                    while ((line=reader.readLine())!=null){
                        builder.append(line);
                    }
                    System.out.println("dsadsadasdas" + builder.toString());
                    return builder.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "none mock data found";
    }
}
