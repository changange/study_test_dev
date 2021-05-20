package cakes.auto.test.driver.case3;

import cakes.auto.AutoTest;
import cakes.auto.driver.CaseGroup;
import cakes.auto.driver.CaseLevel;
import cakes.auto.driver.Level;
import cakes.auto.format.Checkpoint;
import org.junit.jupiter.api.Assertions;

/**
 * Author：耿常安
 * Date：2021-03-30-9:24
 * Description：<描述>
 */
public class Case1 {

    @AutoTest(title = "这是大帅哥", desc = "是的"  ,owner = "gca")
    @CaseGroup({"xiha","erbi"})
    @Checkpoint("sss")
    @CaseLevel(Level.p0)
    public void test311(){
        //用例内部逻辑
        System.out.println("Case1.test311-----P0");
    }

    @AutoTest(title = "这是大帅哥", desc = "是的"  ,owner = "gca")
    @CaseGroup({"xiha","erbi"})
    @Checkpoint("sss")
    @CaseLevel(Level.p1)
    public void test322(){
        //用例内部逻辑
        System.out.println("Case1.test322---P1");

        //断言
        Assertions.assertEquals(1,1);
    }
}
