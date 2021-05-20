package cakes.auto.alarm;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author：耿常安
 * Date：2021-03-27-11:21
 * Description：<描述>
 */

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(AlarmExtension.class)
public @interface AlarmConfig {
    String token();
}
