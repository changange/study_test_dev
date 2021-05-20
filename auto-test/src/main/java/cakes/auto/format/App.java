package cakes.auto.format;

import cakes.auto.AutoTest;
import org.junit.jupiter.api.Test;

/**
 * Author：耿常安
 * Date：2021-03-24-14:56
 * Description：<描述>
 */
public class App {

    /**
     * test一个方法就是一个用例，用例执行的最小单元
     * 自己写的注解没有绿色的小箭头执行
     */
    @AutoTest(title = "xx",desc = "yyyy",owner = "耿常安")   //Test->AutoTest
    //用例描述
    @Checkpoint("验证接口的返回数据XXX")
    @Checkpoint("验证接口的逻辑XXX")
    @Warning("这里是失败之后的提示信息")
    @Warning("这里是警告信息2")

    //@TargetEvn("xxxxxx")
    //@Init(evn={name=xxx,token="xxx"})
    public void testNorma1(){
        System.out.println("App.testNormal");

        //初始化

        //数据准备

        //发起接口请求

        //结果断言

        //逻辑断言

        //清理
    }

    @Test
    public void testNorma2(){

        //初始化

        //数据准备

        //发起接口请求

        //结果断言

        //逻辑断言

        //清理
    }

    /**
     * 任务执行的最小单元
     * 执行上边的一批test
     *
     * 用例的驱动
     */
    @Test
    public void testRun(){

    }
}
