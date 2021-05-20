package cakes.auto.test.driver.cakes1;

import cakes.auto.AutoTest;
import cakes.auto.driver.CaseGroup;
import cakes.auto.driver.CaseLevel;
import cakes.auto.driver.Level;
import cakes.auto.format.Checkpoint;

/**
 * Author：耿常安
 * Date：2021-03-29-22:46
 * Description：<描述>
 */
public class Case2 {

    @AutoTest(title = "xxx", desc = "shuinan", owner = "gca")
    @Checkpoint("xxx")
    public void test112(){
        System.out.println("Case2.test4");
    }

    @AutoTest(title = "xxx", desc = "shuinan", owner = "gca")
    @Checkpoint("xxx")
    @CaseGroup({"xiha","erbi"})
    @CaseLevel(Level.p0)
    public void test113(){
        System.out.println("Case2.test113");
    }

    @AutoTest(title = "xxx", desc = "shuinan", owner = "gca")
    @Checkpoint("xxx")
    @CaseGroup({"doubi"})
    @CaseLevel(Level.p1)
    public void test114(){
        System.out.println("Case2.test113");
    }
}
