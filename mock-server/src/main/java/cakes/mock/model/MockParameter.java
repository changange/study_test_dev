package cakes.mock.model;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author：耿常安
 * Date：2021-04-03-9:17
 * Description：<描述>
 */
public class MockParameter {
    private String mockUri;

    //accountId=123;
    //accountName=gca;
    private Map<String,String> paramMap;

    //拿到请求mock服务是的IP地址
    private String requestHost;

    public String getMockUri() {
        return mockUri;
    }

    //地址 /转换成-
    public String getMockPath() {
        return StringUtils.replace(mockUri,"/","-");
    }


    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public String getRequestHost() {
        return requestHost;
    }

    public void setMockUri(String mockUri) {
        this.mockUri = mockUri;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public void setRequestHost(String requestHost) {
        this.requestHost = requestHost;
    }

    //key=accountId,value=123
    //accountId=123;
    public String getParameterEntry(String key){  //拿到某个参数
        return key+ "=" +this.getParamMap().get(key);
    }

    //没有key 返回全部
    public List<String> getParameterEntry(){
        return this.getParamMap()
                .entrySet()
                .stream()
                .map(entry->entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.toList());
    }

    //判断是否有Entry
    public boolean contationsParameterEntry(String key,String value){
        return this.getParamMap().containsKey(key) && this.getParamMap().get(key).equals(value);
    }
}
