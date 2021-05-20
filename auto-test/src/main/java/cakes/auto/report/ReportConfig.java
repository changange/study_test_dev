package cakes.auto.report;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author：耿常安
 * Date：2021-03-27-0:03
 * Description： 发送报告、钉钉 ,额外讲解
 *      1
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportConfig {

    //报告类型
    ReportType type();

    String value() default "";
}
