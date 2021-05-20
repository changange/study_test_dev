package cakes.auto.format;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

/**
 * Author：耿常安
 * Date：2021-03-24-21:24
 * Description：
 * BeforeTestExecutionCallback：写到其他注解上，执行test的时候先执行这个方法的东西，再执行test方法里边的逻辑
 */

/**
 * junit的东西
 */
public class FormatCheckerExiension implements BeforeTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        //反射拿到注解？？？？
        Method testMethod = extensionContext.getRequiredTestMethod();

        //这里实现具体的关于格式化的处理

        formatObserverMange.of().format(FormatContext.createContext(testMethod));

        //1、逻辑1

        //2、逻辑2
    }
}
