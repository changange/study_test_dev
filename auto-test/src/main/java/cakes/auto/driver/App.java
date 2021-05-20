package cakes.auto.driver;

import cakes.auto.AutoDriver;
import cakes.auto.report.ReportConfig;
import cakes.auto.report.ReportType;

/**
 * Author：耿常安
 * Date：2021-03-25-9:23
 * Description： 指定跑哪些测试代码
 */
public class App {

    @AutoDriver(byPackage = "cakes.auto.test")         //场景2
    @ReportConfig(type = ReportType.html,value = "tocken信息")   //这里加了reportconfig才会发送出去
    public void testRun2(){     //第一批执行的用例

    }

    @AutoDriver(byClass = "cakes.auto.test.format.Case1")         //场景2
    public void testRun1(){     //第一批执行的用例
    }

    @AutoDriver(byClasses = {"cakes.auto.test.format.Case1","cakes.auto.test.format.Case2"})         //场景2
    public void testRun3(){     //第一批执行的用例

    }

    /**
     * 最原始的代码
     */
    //public static void main(String[] args) {
    //    Launcher launcher = LauncherFactory.create();
    //
    //    launcher.execute(LauncherDiscoveryRequestBuilder.request()
    //            .selectors(DiscoverySelectors.selectPackage("cakes.auto.test"))
    //            .build()
    //    );
    //}
}
