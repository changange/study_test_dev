package cakes.auto.test.driver;

import cakes.auto.AutoDriver;
import cakes.auto.driver.Level;

/**
 * Author：耿常安
 * Date：2021-03-29-22:43
 * Description：<描述>
 */
public class App {

    //@AutoDriver(byClasses = "cakes.auto.test.driver.cakes1.Case1")
    @AutoDriver(byPackage = "cakes.auto.test.driver.cakes1",parallrl = true) //多线程执行
    public void testDriver1(){
        try {
            Thread.sleep(300*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //执行p0和p1级别的用例
    @AutoDriver(byPackage = "cakes.auto.test.driver.cakes",byLevel = {Level.p0,Level.p1})
    public void testDriver2(){

    }

    //执行哪些分组
    @AutoDriver(byGroup = {"xiha","doubi"},byLevel = {Level.p0,Level.p1})
    public void testDriver3(){

    }

    //@AutoDriver(byPackage = "cakes.auto.test.driver.case2",byLevel = {Level.p0})
    //@AutoDriver(byPackage = "cakes.auto.test.driver.case2")
    @AutoDriver(byPackage = "cakes.auto.test.driver.case3",byLevel = {Level.p1,Level.p0})
    public void testDriver4(){

    }
}
