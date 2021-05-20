import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author：耿常安
 * Date：2021-03-03-15:56
 * Description：<描述>
 */
//标注这是主程序类，是一个springboot的应用
@SpringBootApplication
@ComponentScan("com.itany.controller")      //当主程序不在主目录下，要手动配置扫哪些包
public class MainApplication {
    public static void main(String[] args) {
        //启动springboot应用
        //参数传入主程序类的class对象
        SpringApplication.run(MainApplication.class, args);
    }
}

