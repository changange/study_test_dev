package cakes.auto.test.model;

/**
 * Author：耿常安
 * Date：2021-03-27-19:41
 * Description：<描述>
 *     1
 */
public class OrderDetail {

    private Integer orderId;
    private String orderInfo;
    private Long amount;
    private String payInfo;

    public OrderDetail() {
    }



    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", orderInfo='" + orderInfo + '\'' +
                ", amount='" + amount + '\'' +
                ", payInfo='" + payInfo + '\'' +
                '}';
    }
}
