package cakes.auto.format;

import com.google.common.base.Strings;

import java.lang.reflect.Method;

/**
 * Author：耿常安
 * Date：2021-03-24-22:16
 * Description：     //3、Warning的判断处理
 */
public class WarningsFormatObserver implements FormatObserver{
    @Override
    public void update(FormatContext context) {
        Method testMethod = context.getTestMethod();

        /**
         * @warning这个注解可以没有，如果有了报错信息 value就不可以为null
         */

        Warning[] warnings = testMethod.getAnnotationsByType(Warning.class);
        if (warnings.length==0){
            return;
        }

        for (Warning warning:warnings){
            String value = warning.value();
            if(Strings.isNullOrEmpty(value)){
                throw new FormatException("@warningpoint value should not null or emptys");
            }
        }
    }
}
