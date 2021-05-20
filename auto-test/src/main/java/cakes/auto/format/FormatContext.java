package cakes.auto.format;

import java.lang.reflect.Method;

/**
 * Author：耿常安
 * Date：2021-03-24-21:51
 * Description： 格式化的上下文，用于做各种格式化时的信息传递
 */

public class FormatContext {
    private Method testMethod;

    private FormatContext() {
    }

    public FormatContext(Method testMethod) {
        this.testMethod = testMethod;
    }

    public Method getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(Method testMethod) {
        this.testMethod = testMethod;
    }

    //静态工厂构造方法
    public static FormatContext createContext(){

        return new FormatContext();
    }

    public static FormatContext createContext(Method testMethod){
        return new FormatContext(testMethod);
    }


    @Override
    public String toString() {
        return "FormatContext{" +
                "testMethod=" + testMethod +
                '}';
    }
}
