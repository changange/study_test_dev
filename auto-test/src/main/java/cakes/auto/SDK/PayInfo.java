package cakes.auto.SDK;

/**
 * Author：耿常安
 * Date：2021-04-01-22:10
 * Description：<描述>
 */
public class PayInfo {

    private String token;
    private String payId;
    private Long amount;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
