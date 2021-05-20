package cakes.auto.test.format;

import cakes.auto.AutoTest;
import cakes.auto.alarm.AlarmConfig;
import cakes.auto.format.Checkpoint;
import cakes.auto.format.Warning;

/**
 * Author：耿常安
 * Date：2021-03-25-9:03
 * Description：<描述>
 */
public class Case1 {

    @AutoTest(title = "xx",desc = "yyyy",owner = "耿常安")   //Test->AutoTest
    //用例描述
    @Checkpoint("验证接口的返回数据XXX")
    @Checkpoint("验证接口的逻辑XXX")
    @Warning("这里是失败之后的提示信息")
    @Warning("这里是警告信息2")
    @AlarmConfig(token = "xxx")     //报警信息，可以放在执行的方法上，但是很多歌执行的test方法
    public void test1(){
        System.out.println("Case1.test1");
        int a = 1/0;
    }

    @AutoTest(title = "xx",desc = "yyyy",owner = "耿常安")   //Test->AutoTest
    //用例描述
    @Checkpoint("验证接口的返回数据XXX")
    @Checkpoint("验证接口的逻辑XXX")
    @Warning("这里是失败之后的提示信息")
    @Warning("这里是警告信息2")
    public void test2(){
        System.out.println("Case1.test2");

    }

    @AutoTest(title = "xx",desc = "yyyy",owner = "耿常安")   //Test->AutoTest
    //用例描述
    @Checkpoint("验证接口的返回数据XXX")
    @Checkpoint("验证接口的逻辑XXX")
    @Warning("这里是失败之后的提示信息")
    @Warning("这里是警告信息2")
    public void test3(){
        System.out.println("Case1.test3");

    }
}
