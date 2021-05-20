package cakes.auto;

import cakes.auto.provider.AutoProviderExtension;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author：耿常安
 * Date：2021-03-30-11:01
 * Description：
 *      3
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(AutoProviderExtension.class)   //扩展功能，读取配置文件的数据，完成驱动测试
@TestTemplate       //???
public @interface AutoProvider {
    String path();
}
