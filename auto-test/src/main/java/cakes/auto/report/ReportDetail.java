package cakes.auto.report;

import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-03-26-9:10
 * Description：<描述>
 */
public class ReportDetail {

    //总共发现的用例数
    private long testsFoundCount;
    private long timeFinished;   //结束时间
    private long timeStarted;       //开始时间
    private long timeCount;     //总共执行时间
    private long testsSkippedCount;  //跳过总数
    private long testsSucceededCount;
    private long testsFailedCount;
    private long testsAbortedCount;  //拒绝执行
    private long totalFailureCount;  //总计失败的
    private List<Failureason> failures;

    public static ReportDetail fromTestExecutionSummary(TestExecutionSummary summary){
        ReportDetail reportDetail = new ReportDetail();
        //执行了几个测试类
        reportDetail.setTestsFoundCount(summary.getTestsFoundCount());
        reportDetail.setTimeStarted(summary.getTimeStarted());
        reportDetail.setTimeFinished(summary.getTimeFinished());
        reportDetail.setTimeCount(summary.getTimeFinished()-summary.getTimeStarted());
        reportDetail.setTestsSkippedCount(summary.getTestsSkippedCount());
        reportDetail.setTestsSucceededCount(summary.getTestsSucceededCount());
        reportDetail.setTestsFailedCount(summary.getTestsFailedCount());
        reportDetail.setTestsAbortedCount(summary.getTestsAbortedCount());
        reportDetail.setTotalFailureCount(summary.getTotalFailureCount());

        List<TestExecutionSummary.Failure> failures = summary.getFailures();
        reportDetail.setFailures(
                failures.stream().map(failure->{
                    TestIdentifier testIdentifier = failure.getTestIdentifier();    //???
                    Optional<TestSource> source = testIdentifier.getSource();
                    MethodSource testSource = (MethodSource) source.get();

                    Throwable ex = failure.getException();//获取异常

                    return new Failureason(testSource.getClassName(),testSource.getMethodName(),ex.getMessage());
                }).collect(Collectors.toList()));

        return reportDetail;
    }

    public long getTestsFoundCount() {
        return testsFoundCount;
    }

    public void setTestsFoundCount(long testsFoundCount) {
        this.testsFoundCount = testsFoundCount;
    }

    public long getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(long timeFinished) {
        this.timeFinished = timeFinished;
    }

    public long getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(long timeStarted) {
        this.timeStarted = timeStarted;
    }

    public long getTestsSkippedCount() {
        return testsSkippedCount;
    }

    public void setTestsSkippedCount(long testsSkippedCount) {
        this.testsSkippedCount = testsSkippedCount;
    }

    public long getTestsSucceededCount() {
        return testsSucceededCount;
    }

    public void setTestsSucceededCount(long testsSucceededCount) {
        this.testsSucceededCount = testsSucceededCount;
    }

    public long getTestsFailedCount() {
        return testsFailedCount;
    }

    public void setTestsFailedCount(long testsFailedCount) {
        this.testsFailedCount = testsFailedCount;
    }

    public long getTestsAbortedCount() {
        return testsAbortedCount;
    }

    public void setTestsAbortedCount(long testsAbortedCount) {
        this.testsAbortedCount = testsAbortedCount;
    }

    public long getTotalFailureCount() {
        return totalFailureCount;
    }

    public void setTotalFailureCount(long totalFailureCount) {
        this.totalFailureCount = totalFailureCount;
    }

    public List<Failureason> getFailures() {
        return failures;
    }

    public void setFailures(List<Failureason> failures) {
        this.failures = failures;
    }

    public long getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(long timeCount) {
        this.timeCount = timeCount;
    }

    @Override
    public String toString() {
        return "ReportDetail{" +
                "testsFoundCount=" + testsFoundCount +
                ", timeFinished=" + timeFinished +
                ", timeStarted=" + timeStarted +
                ", timeCount=" + timeCount +
                ", testsSkippedCount=" + testsSkippedCount +
                ", testsSucceededCount=" + testsSucceededCount +
                ", testsFailedCount=" + testsFailedCount +
                ", testsAbortedCount=" + testsAbortedCount +
                ", totalFailureCount=" + totalFailureCount +
                ", failures=" + failures +
                '}';
    }
}
