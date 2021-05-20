package cakes.mock.model;

import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-04-06-21:36
 * Description：<描述>
 */
public class CallbackEntity {
    private String url;
    private Map<String,Object> params;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "CallBack{" +
                "url='" + url + '\'' +
                ", params=" + params +
                '}';
    }
}
