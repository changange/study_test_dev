package cakes.auto;

import cakes.auto.format.FormatCheckerExiension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

/**
 * Author：耿常安
 * Date：2021-03-24-20:45
 * Description：自定义注解
 */

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(FormatCheckerExiension.class)   //提前执行这个？？？
@Test       //加上这个就有绿色的小箭头，可以执行
public @interface AutoTest {
    //@CaseTitle("测试XXX接口")
    //@CaseDese("这个用例是要做什么")
    //@CaseOwner("Genghangan")

    String title();

    String desc();

    String owner();
}