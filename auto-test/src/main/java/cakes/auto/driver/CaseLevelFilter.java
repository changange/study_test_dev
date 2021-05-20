package cakes.auto.driver;

import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor;
import org.junit.platform.engine.FilterResult;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.launcher.PostDiscoveryFilter;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Author：耿常安
 * Date：2021-03-30-8:50
 * Description：<描述>
 */
public class CaseLevelFilter implements PostDiscoveryFilter {

    private DriverContext driverContext;

    public CaseLevelFilter(DriverContext driverContext){
        this.driverContext = driverContext;
    }

    @Override
    public FilterResult apply(TestDescriptor testDescriptor) {
        //如果没有设置
        if(this.driverContext.getByLevel().isEmpty()){
            return FilterResult.includedIf(true);
        }

        Method testMethod = null;
        //专门获取TestTemplate一类的用例标示
        if(testDescriptor instanceof TestTemplateTestDescriptor){
            testMethod = ((TestTemplateTestDescriptor) testDescriptor).getTestMethod();
        }

        //正常的获取Test类型的Test Method
        if (testDescriptor instanceof TestMethodTestDescriptor){    //自己的注解
            testMethod = ((TestMethodTestDescriptor)testDescriptor).getTestMethod();
        }

        if (Objects.isNull(testMethod)){
            return FilterResult.includedIf(true);
        }

        //判断方法是否有注解标识
        boolean isCaselevelSet = testMethod.isAnnotationPresent(CaseLevel.class);
        if (!isCaselevelSet){
            //没有注解返回false。没有@CaseLEvel注解，就不被选中
            return FilterResult.includedIf(false);
        }

        //从test method拿到CaseLEvel这个注解，然后取出次注解的Level信息
        Level level = testMethod.getAnnotation(CaseLevel.class).value();

        //与我们的AutoDriver上的byLevel的数据进行判断，如果当前的method上有我们要做筛选的Level，则此用例被选中
        if (this.driverContext.getByLevel().contains(level)){
            return FilterResult.includedIf(true);
        }

        //否则没有
        return FilterResult.includedIf(false);
    }
}
