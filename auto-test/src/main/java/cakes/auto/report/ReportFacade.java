package cakes.auto.report;

import org.apache.commons.lang3.StringUtils;

/**
 * Author：耿常安
 * Date：2021-03-26-23:55
 * Description：<描述>
 */
public class ReportFacade {

    public static void handleReport(ReportContext context){
        if(!context.isReportSending()){
            //是否发送报告
            //没有配置@ReportConfig 因此就不需要发送报告
            return;
        }

        ReportDetail reportDetail = ReportDetail.fromTestExecutionSummary(context.getSummry());

        //策略模式
        ReportType reportType = context.getReportType();
        if(reportType==ReportType.dingTalks){
            //发送钉钉
            DingTalkUtils.sendReport(reportDetail);
        }

        //在自己本地写一个HTML文件
        if(reportType==ReportType.html){
            //html
            //加载资源文件report_temolate.html
            //想要实现报告的点击跳转，就先写一堆HTML，定义一些错误的HTML，然后点击就跳转到错误的页面

            String reportTempleteString = "";
            //做数据匹配替换
            StringUtils.replace(reportTempleteString,"${successfulCount}",reportDetail.getTestsAbortedCount()+"");  //只是举个例子
            StringUtils.replace(reportTempleteString,"${failedfulCount}",reportDetail.getTestsAbortedCount()+"");  //只是举个例子

            //html文件输出
            System.out.println("耿常安 ： " + reportTempleteString);
        }

        if(reportType==ReportType.xml){
            //xml
        }
    }
}
