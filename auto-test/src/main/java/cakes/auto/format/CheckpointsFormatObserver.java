package cakes.auto.format;

import com.google.common.base.Strings;

import java.lang.reflect.Method;

/**
 * Author：耿常安
 * Date：2021-03-24-22:16
 * Description：     //2、Checkpoint的非空判断
 */
public class CheckpointsFormatObserver implements FormatObserver{
    @Override
    public void update(FormatContext context) {
        Method testMethod = context.getTestMethod();
        /**
         * 应为这个注解在同一个方法写了多个，所以不能直接判断是不是写了这个注解
         * 要拿到所有的注解在判断是不是有这个注解
         */
        Checkpoint[] checkpoints = testMethod.getAnnotationsByType(Checkpoint.class);

        if (checkpoints.length==0){
            throw new FormatException("@Checkpoin shoulb be test");
        }

        for (Checkpoint checkpoint:checkpoints){
            String value = checkpoint.value();
            if(Strings.isNullOrEmpty(value)){
                throw new FormatException("@Checkpoint value should not null or emptys");
            }
        }
    }
}
