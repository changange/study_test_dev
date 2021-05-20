package cakes.auto.alarm;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.lang.reflect.Method;

/**
 * Author：耿常安
 * Date：2021-03-27-11:18
 * Description： 错误报警
 *
 * TestExecutionExceptionHandler
 */
public class AlarmExtension implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        //拿到的预警信息
        Class<?> stestClass = extensionContext.getRequiredTestClass();
        Method testMethod = extensionContext.getRequiredTestMethod();
        String message = throwable.getMessage();
        StackTraceElement[] stackTrace = throwable.getStackTrace();

        System.out.println(stestClass+"," +testMethod+"," +message);
    }
}
