package cakes.auto;

import cakes.auto.driver.DriverExiension;
import cakes.auto.driver.Level;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author：耿常安
 * Date：2021-03-24-20:45
 * Description：自定义注解
 */

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DriverExiension.class)
@Test       //加上这个就有绿色的小箭头，可以执行
public @interface AutoDriver {

    String byPackage() default "";

    String byClass() default "";

    String[] byClasses() default "";

    Level[] byLevel() default {};
    String[] byGroup() default {};

    //并行相关支持
    boolean parallrl() default false;   //默认不开启

    //从这里扩展过去的
    //configMap.put("junit.jupiter.execution.parallel.enabled","true");
    //        configMap.put("junit.jupiter.execution.parallel.mode.default","concurrent");
    //        configMap.put("junit.jupiter.execution.parallel.mode.classes.default","concurrent");
    //        configMap.put("junit.jupiter.execution.parallel.config.fixed.parallelism","16");    //线程数
}
