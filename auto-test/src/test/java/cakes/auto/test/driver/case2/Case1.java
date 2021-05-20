package cakes.auto.test.driver.case2;

import cakes.auto.AutoProvider;
import cakes.auto.driver.CaseLevel;
import cakes.auto.driver.Level;
import cakes.auto.provider.ParamNamed;
import cakes.auto.test.model.AccountInfo;
import cakes.auto.test.model.OrderDetail;

/**
 * Author：耿常安
 * Date：2021-03-30-9:24
 * Description：<描述>
 */
public class Case1 {

    @AutoProvider(path = "data/test-data.yml")      //读取文件的数据
    @CaseLevel(Level.p0)
    public void test311(@ParamNamed("orderDetail") OrderDetail orderDetail, @ParamNamed("accountInfo") AccountInfo accountInfo){
        //用例内部逻辑
        System.out.println("cakes.auto.test.App.test555= " + orderDetail);
        System.out.println("cakes.auto.test.App.test15551= " + accountInfo);
    }

    @AutoProvider(path = "data/test-data.yml")      //读取文件的数据
    @CaseLevel(Level.p1)
    public void test322(@ParamNamed("orderDetail") OrderDetail orderDetail, @ParamNamed("accountInfo") AccountInfo accountInfo){
        //用例内部逻辑
        System.out.println("cakes.auto.test.App.test666= " + orderDetail);
        System.out.println("cakes.auto.test.App.test666= " + accountInfo);
    }
}
