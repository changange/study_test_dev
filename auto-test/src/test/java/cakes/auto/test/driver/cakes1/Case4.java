package cakes.auto.test.driver.cakes1;

import cakes.auto.AutoProvider;
import cakes.auto.driver.CaseGroup;
import cakes.auto.driver.CaseLevel;
import cakes.auto.driver.Level;
import cakes.auto.provider.ParamNamed;
import cakes.auto.test.model.AccountInfo;
import cakes.auto.test.model.OrderDetail;

/**
 * Author：耿常安
 * Date：2021-03-29-22:46
 * Description：<描述>
 */
public class Case4 {

    @AutoProvider(path = "data/test-data.yml")      //读取文件的数据
    @CaseGroup({"doubi"})
    @CaseLevel(Level.p1)
    public void test111(@ParamNamed("orderDetail") OrderDetail orderDetail, @ParamNamed("accountInfo") AccountInfo accountInfo){
        //用例内部逻辑
        System.out.println("App.test111= " + orderDetail);
        System.out.println("App.test111= " + accountInfo);
    }

    @AutoProvider(path = "data/test-data.yml")      //读取文件的数据
    @CaseGroup({"doubi"})
    @CaseLevel(Level.p3)
    public void test112(@ParamNamed("orderDetail") OrderDetail orderDetail, @ParamNamed("accountInfo") AccountInfo accountInfo){
        //用例内部逻辑
        System.out.println("App.test111= " + orderDetail);
        System.out.println("App.test111= " + accountInfo);
    }
    @AutoProvider(path = "data/test-data.yml")      //读取文件的数据
    @CaseGroup({"doubi"})
    @CaseLevel(Level.p2)
    public void test113(@ParamNamed("orderDetail") OrderDetail orderDetail, @ParamNamed("accountInfo") AccountInfo accountInfo){
        //用例内部逻辑
        System.out.println("App.test111= " + orderDetail);
        System.out.println("App.test111= " + accountInfo);

        try {
            Thread.sleep(300*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
