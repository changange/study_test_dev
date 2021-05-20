package com.itany.producer;

/**
 * Author：耿常安
 * Date：2021-03-22-8:06
 * Description：<描述>
 */
public class PayDetail {
    private String payId;
    private Long createTime;
    private Long amount;

    public PayDetail() {
    }

    public PayDetail(String payId, Long createTime, Long amount) {
        this.payId = payId;
        this.createTime = createTime;
        this.amount = amount;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayDetail{" +
                "payId='" + payId + '\'' +
                ", createTime=" + createTime +
                ", amount=" + amount +
                '}';
    }
}
