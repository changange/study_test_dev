package cakes.auto.report;

import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.lang.reflect.Method;

/**
 * Author：耿常安
 * Date：2021-03-27-0:12
 * Description：用于发送报告的tocken信息传递
 *
 * 3
 */
public class ReportContext {

    private ReportType reportType;
    private String token;
    private TestExecutionSummary summry;

    private boolean isReportSending;    //是否发送报告

    /**
     * 静态工厂构造器
     * @return
     */
    public static ReportContext createContext(Method testMethod, TestExecutionSummary summary){
        ReportContext context = new ReportContext();
        boolean isReportConfig = testMethod.isAnnotationPresent(ReportConfig.class);
        if (isReportConfig) {
            ReportConfig reportConfig = testMethod.getAnnotation(ReportConfig.class);
            context.setReportType(reportConfig.type());
            context.setSummry(summary);
            context.setToken(reportConfig.value());
            context.setReportSending(true);     //
            return context;
        }

        context.setReportSending(false);
        return context;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TestExecutionSummary getSummry() {
        return summry;
    }

    public void setSummry(TestExecutionSummary summry) {
        this.summry = summry;
    }

    public boolean isReportSending() {
        return isReportSending;
    }

    public void setReportSending(boolean reportSending) {
        this.isReportSending = reportSending;
    }

    @Override
    public String toString() {
        return "ReportContext{" +
                "reportType=" + reportType +
                ", token='" + token + '\'' +
                ", summry=" + summry +
                ", isReportSending=" + isReportSending +
                '}';
    }
}
