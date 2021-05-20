package cakes.auto.provider;

import cakes.auto.AutoProvider;
import cakes.auto.util.MapperUtils;
import cakes.auto.util.YmlUtils;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Author：耿常安
 * Date：2021-03-27-20:30
 * Description： 实现读取配置文件的数据，完成数据的驱动
 * 1、添加扩展，实现接口TestTemplateInvocationContextProvider
 *  --基于Junit5的扩展实现
 * 2、基于@AutoProvider所制定 的path读取数据
 *  --基本数据类型
 *  --自定义对象，基于yml文件来描述一个实体对象，然后取出之后，做映射
 * 3、读取的数据作为用例运行的每一次输入参数
 *  --为每一次的解析封装返回的参数对象
 *      4
 */
public class AutoProviderExtension implements TestTemplateInvocationContextProvider {

    //前置判断  判断template是否在当前类执行
    //判断方法上是否有 AutoProvider注解，有就支持模板
    @Override
    public boolean supportsTestTemplate(ExtensionContext extensionContext) {
        return AnnotationSupport.isAnnotated(extensionContext.getRequiredTestMethod(), AutoProvider.class);
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext) {
        //如：读取数据的时候循环几次
        //Stream<TestTemplateInvocationContext>这里用stream包裹
        //返回的一次执行，相当于是一个TestTemplateInvocationContext，如果数据驱动有100个那么揪心相当于返回100个TestTemplateInvocationContext
        //这100个TestTemplateInvocationContext  用stream装起来返回

        //return Stream.of(new TestTemplateInvocationContext() {//数据},
        //        new TestTemplateInvocationContext() {}
        //);  //两个，就执行两次

        //2、在这里需要解析出数据
        //读取@AutoProvider 属性path指定的路径文件，并解析出文件数据
        //封装成一个数据的列表，比如  List<DrderDetail>

        //拿到当前正在执行的方法
        Method testMethod = extensionContext.getRequiredTestMethod();
        //取出该方法的AutoProvider注解并拿到path路径
        AutoProvider autoProvider = testMethod.getAnnotation(AutoProvider.class);
        String path = autoProvider.path();
        //去path上解析数据
        List<Map<String, Object>> dataList = YmlUtils.parse(path);
        System.out.println("解析出来的数据" + dataList);

        //return dataList.stream().map(data->
        //    new AutoProviderTestTemplateInvocationContext(data));

        //3、将List<OrderDetail> ==> List<TestTemplateInvocationContext>
        // return dataList.stream().map(AutoProviderTestTemplateInvocationContext::new);
        return dataList.stream().map(x -> new AutoProviderTestTemplateInvocationContext(x));
    }


    static class AutoProviderTestTemplateInvocationContext implements TestTemplateInvocationContext{

        private Map<String,Object> data;
        public AutoProviderTestTemplateInvocationContext(Map<String,Object> data) {
            this.data=data;
        }

        //一个参数就是一个AutoProviderParameterResolver
        @Override
        public List<Extension> getAdditionalExtensions() {
            //实现一次真正意义上的分装，因为此时是参数化设计
            //实现自己的parameterResoler。无论几个参数都是一个解析器
            // Collections.singletonList：返回一个不可变集合

            return Collections.singletonList(new AutoProviderParameterResolver(data));
        }
    }

    //参数的解析，完成参数的转化
    static class AutoProviderParameterResolver implements ParameterResolver{
        private final Map<String,Object> data;

        public AutoProviderParameterResolver(Map<String, Object> data) {
            this.data = data;
        }

        //是否支持什么什么
        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return true;
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            //取出当前的参数类型  OrderDetail
            Parameter parameter = parameterContext.getParameter();
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + parameter);
            //找到注解paramNamed表示的value
            ParamNamed paramNamed = parameter.getAnnotation(ParamNamed.class);
            System.out.println("llllllllllllllllllllllll" + paramNamed);


            // TODO 这里是数据的获取，需要注意一般异常的情况，做下判断

            //然后开始做判断，就是找到里面定义的数据

            //yml数据解析出的数据转换成了linkHashMap，所以要对数据的转换
            Object val = data.get(paramNamed.value());//{account=456, accountName=hehe}
            System.out.println("mmmmmmmmmmmmmmmmmmm" + val);

            //在这里完成Map -> Object
            // parameter.getType()    class cakes.auto.test.model.OrderDetail
            return MapperUtils.mapToObject(val,parameter.getType());
        }
    }
}
