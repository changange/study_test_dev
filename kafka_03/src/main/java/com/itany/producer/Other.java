package com.itany.producer;

/**
 * Author：耿常安
 * Date：2021-03-22-7:45
 * Description：序列化讲解
 */
public class Other {

    private String oderId;
    private Integer amount;

    public Other() {
    }

    public Other(String oderId, Integer amount) {
        this.oderId = oderId;
        this.amount = amount;
    }

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Other{" +
                "oderId='" + oderId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
