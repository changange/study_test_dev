package cakes.auto.format;

import java.lang.annotation.*;

/**
 * Author：耿常安
 * Date：2021-03-24-20:45
 * Description：自定义注解
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Checkpoints.class)   //加多个同样的注解
public @interface Checkpoint {
    String value();
}
