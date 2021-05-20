package cakes.mock.model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author：耿常安
 * Date：2021-04-06-22:37
 * Description： 对参数的修改（MockController重构）
 */
public class MockContext {
    private MockHeader mockHeader;

    private HttpServletRequest httpRequest;

    private List<MockConfig> localMockConfigs;

    //目标的config
    private MockConfig targetMockConfig;

    private MockParameter mockParameter;
    private String targetMockData;

    public MockContext() {
    }

    public MockContext(HttpServletRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public List<MockConfig> getLocalMockConfigs() {
        return localMockConfigs;
    }

    public void setLocalMockConfigs(List<MockConfig> localMockConfigs) {
        this.localMockConfigs = localMockConfigs;
    }

    public MockConfig getTargetMockConfig() {
        return targetMockConfig;
    }

    public void setTargetMockConfig(MockConfig targetMockConfig) {
        this.targetMockConfig = targetMockConfig;
    }

    public MockParameter getMockParameter() {
        return mockParameter;
    }

    public void setMockParameter(MockParameter mockParameter) {
        this.mockParameter = mockParameter;
    }

    public HttpServletRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpServletRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public String getTargetMockData() {
        return targetMockData;
    }

    public void setTargetMockData(String targetMockData) {
        this.targetMockData = targetMockData;
    }

    public MockHeader getMockHeader() {
        return mockHeader;
    }

    public void setMockHeader(MockHeader mockHeader) {
        this.mockHeader = mockHeader;
    }

    @Override
    public String toString() {
        return "MockContext{" +
                "httpRequest=" + httpRequest +
                ", localMockConfigs=" + localMockConfigs +
                ", targetMockConfig=" + targetMockConfig +
                ", mockParameter=" + mockParameter +
                ", targetMockData='" + targetMockData + '\'' +
                '}';
    }
}
