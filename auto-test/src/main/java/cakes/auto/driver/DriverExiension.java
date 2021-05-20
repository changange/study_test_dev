package cakes.auto.driver;

import cakes.auto.AutoDriver;
import cakes.auto.report.ReportContext;
import cakes.auto.report.ReportFacade;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.Filter;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.PostDiscoveryFilter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-03-25-22:01
 * Description：<描述>
 */
public class DriverExiension implements BeforeTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        //1、解析出@AutoDriver的相关参数信息，已完成后续的的驱动能力
        Method testMethod = extensionContext.getRequiredTestMethod();
        AutoDriver driver = testMethod.getAnnotation(AutoDriver.class);
        DriverContext context = DriverContext.createContext(driver);

        //构建执行Launcher时的发现请求类
        LauncherDiscoveryRequestBuilder launcherDiscoveryRequestBuilder = LauncherDiscoveryRequestBuilder.request()
                .selectors(createSelectors(context))
                .filters(creatFilters(context).toArray(new Filter<?>[0])) //过滤器，执行按照分组，级别执行用例
                .listeners();

        if(driver.parallrl()){  //此时开启并行
            //多线程
            Map<String,String> configMap = Maps.newConcurrentMap();
            configMap.put("junit.jupiter.execution.parallel.enabled","true");
            //是否支持方法级别多线程
            configMap.put("junit.jupiter.execution.parallel.mode.default","concurrent");
            //是否支持类级别多线程
            configMap.put("junit.jupiter.execution.parallel.mode.classes.default","concurrent");

            configMap.put("junit.jupiter.execution.parallel.config.strategy","fixed");
            configMap.put("junit.jupiter.execution.parallel.config.fixed.parallelism","3");    //线程数
            launcherDiscoveryRequestBuilder.configurationParameters(configMap);
        }

        LauncherDiscoveryRequest build = launcherDiscoveryRequestBuilder.build();
        //创建驱动用例执行的主类 Launcher
        Launcher launcher = LauncherFactory.create();
        //新建结果收集的接听器
        SummaryGeneratingListener sum = new SummaryGeneratingListener();
        //将结果收集监听器注册进 Launcher，此种方式适用于Launcher驱动多个LauncherDiscoveryRequest是
        launcher.registerTestExecutionListeners(sum);

        //执行用例
        launcher.execute(build);

        //从sum拿到用例执行后的统计信息
        TestExecutionSummary summary = sum.getSummary();

        //执行报告
        System.out.println("0---------------------" + testMethod.getName());
        ReportFacade.handleReport(ReportContext.createContext(testMethod,summary));
        /**
         * 下边拿到里边去
         */
        ////构建报告实体信息
        // ReportDetail reportDetail = ReportDetail.fromTestExecutionSummary(summary);
        //
        ////报告发给其他人或者其他处理
        ////给钉钉发送报告信息
        // System.out.println(reportDetail);
        //DingTalkUtils.sendReport(reportDetail);
    }

    //筛选
    private List<PostDiscoveryFilter> creatFilters(DriverContext context) {

        List<PostDiscoveryFilter> filters = Lists.newArrayList();
        //filters.add(new CaseGroupFilter(context));
        filters.add(new CaseLevelFilter(context));
        return filters;
    }

    //定义一个select
    private List<DiscoverySelector> createSelectors(DriverContext context){
        List<DiscoverySelector> selectors = Lists.newArrayList();

        if (!Strings.isNullOrEmpty(context.getByPackage())){
            selectors.add(DiscoverySelectors.selectPackage(context.getByPackage()));
        }

        if (!Strings.isNullOrEmpty(context.getbyClass())) {
            selectors.add(DiscoverySelectors.selectClass(context.getbyClass()));
        }

        selectors.addAll(Arrays.stream(context.getByClasses())
                .filter(className -> !Strings.isNullOrEmpty(className))     //过滤空和null
                .map(DiscoverySelectors::selectClass)
                //.map(classNmae->DiscoverySelectors.selectClass(classNmae))
                .collect(Collectors.toList()));

        return selectors;
    }
}
