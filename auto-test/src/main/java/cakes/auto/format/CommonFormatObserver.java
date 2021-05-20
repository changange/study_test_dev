package cakes.auto.format;

import cakes.auto.AutoTest;
import com.google.common.base.Strings;

import java.lang.reflect.Method;

/**
 * Author：耿常安
 * Date：2021-03-24-22:16
 * Description：     //1、AutoTest本身的三个属性
 */
public class CommonFormatObserver implements FormatObserver{
    @Override
    public void update(FormatContext context) {
        Method testMethod = context.getTestMethod();
        AutoTest annotation = testMethod.getAnnotation(AutoTest.class);
        String title = annotation.title();
        if (Strings.isNullOrEmpty(title)){
            throw new FormatException("auto test title should not be  null or empty");
        }
        String desc = annotation.desc();
        if (Strings.isNullOrEmpty(desc)){
            throw new FormatException("auto test desc should not be  null or empty");
        }
        String owner = annotation.owner();
        if (Strings.isNullOrEmpty(owner)){
            throw new FormatException("auto test owner should not be  null or empty");
        }
    }
}
