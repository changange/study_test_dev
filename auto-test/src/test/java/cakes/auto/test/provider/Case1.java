package cakes.auto.test.provider;

import cakes.auto.AutoProvider;
import cakes.auto.provider.ParamNamed;
import cakes.auto.test.model.AccountInfo;
import cakes.auto.test.model.OrderDetail;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Author：耿常安
 * Date：2021-03-27-19:24
 * Description： 数据驱动
 *
 * 我们要做的事情就是，数据驱动是对象类型，不是基本的数据类型
 */
public class Case1 {

    /**
     * 驱动复杂的数据对象
     * 这就是数据驱动，用例架子和数据非分离
     */
    //@AutoTest(title = "测试",desc = "标题",owner = "shuainan")
    @AutoProvider(path = "data/test-id.yml")      //读取文件的数据
    public void test1(OrderDetail orderDetail){

        //用例内部逻辑
        System.out.println("User："+ orderDetail);
    }

    //@AutoTest(title = "测试",desc = "标题",owner = "shuainan")
    @AutoProvider(path = "data/test-id.yml")      //读取文件的数据
    public void test2(){
        //用例内部逻辑
        System.out.println("cakes.auto.test.App.test2");
    }


    /**
     * 方式2：数据驱动
     * 驱动基本的数据测试类型
     */
    @ParameterizedTest
    // @ValueSource(strings = {"hello","yes","hehe"})
    @ValueSource(ints = {1,3,4})
    public void test3(int str){
        System.out.println("str : " + str);
    }


    //@Test     //支持无参测试，写了Test和AutoProvider这个方法就会调用两次，这两个都是调用的意思
    @AutoProvider(path = "data/test-data.yml")      //读取文件的数据
    public void test4(@ParamNamed("orderDetail") OrderDetail orderDetail, @ParamNamed("accountInfo") AccountInfo accountInfo){
        //用例内部逻辑
        System.out.println("cakes.auto.test.App.test4= " + orderDetail);
        System.out.println("cakes.auto.test.App.test4= " + accountInfo);
    }

    @AutoProvider(path = "data/test-id.yml")      //读取文件的数据
    public void test5(@ParamNamed("str1") String str1,@ParamNamed("str2") String str2){
        //用例内部逻辑
        System.out.println("cakes.auto.test.App.test5 = " + str1 + ":" + str2);
    }
}
