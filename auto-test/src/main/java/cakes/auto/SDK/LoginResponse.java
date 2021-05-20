package cakes.auto.SDK;

/**
 * Author：耿常安
 * Date：2021-04-01-23:03
 * Description：<描述>
 */
public class LoginResponse {
    private String token;
    private Long createTime;
    private String userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
