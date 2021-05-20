package cakes.mock.model;

import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-04-03-17:12
 * Description：<描述>
 */
public class MockConfig {
    private Map<String,MockEntity> mappingParams;

    private String mockData;

    //解决mockpath  数据分离的文件
    private String mockPath;

    //多少秒返回结果
    private TimeEntity thinkingTime;

    //回调URL
    private CallbackEntity callback;

    //透传
    private String  penetrate;

    public Map<String, MockEntity> getMappingParams() {
        return mappingParams;
    }

    public void setMappingParams(Map<String, MockEntity> mappingParams) {
        this.mappingParams = mappingParams;
    }

    public String getMockData() {
        return mockData;
    }

    public void setMockData(String mockData) {
        this.mockData = mockData;
    }

    public String getMockPath() {
        return mockPath;
    }

    public void setMockPath(String mockPath) {
        this.mockPath = mockPath;
    }

    public TimeEntity getThinkingTime() {
        return thinkingTime;
    }

    public void setThinkingTime(TimeEntity thinkingTime) {
        this.thinkingTime = thinkingTime;
    }

    public CallbackEntity getCallback() {
        return callback;
    }

    public void setCallback(CallbackEntity callback) {
        this.callback = callback;
    }

    public String getPenetrate() {
        return penetrate;
    }

    public void setPenetrate(String penetrate) {
        this.penetrate = penetrate;
    }

    @Override
    public String toString() {
        return "MockConfig{" +
                "mappingParams=" + mappingParams +
                ", mockData='" + mockData + '\'' +
                ", mockPath='" + mockPath + '\'' +
                ", thinkingTime=" + thinkingTime +
                ", callback=" + callback +
                ", penetrate='" + penetrate + '\'' +
                '}';
    }
}
