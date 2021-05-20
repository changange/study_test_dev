package cakes.auto.test.model;

/**
 * Author：耿常安
 * Date：2021-03-28-22:01
 * Description：<描述>
 *     6
 */
public class PayInfo {

    private Integer id;
    private String payId;

    public PayInfo() {
    }

    public PayInfo(Integer id, String payId) {
        this.id = id;
        this.payId = payId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    @Override
    public String toString() {
        return "PayInfo{" +
                "id=" + id +
                ", payId='" + payId + '\'' +
                '}';
    }
}
