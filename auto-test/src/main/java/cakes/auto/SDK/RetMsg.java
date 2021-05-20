package cakes.auto.SDK;

/**
 * Author：耿常安
 * Date：2021-04-01-22:10
 * Description：<描述>
 */
public class RetMsg<T> {
    private Integer retNo;
    private String resMsg;
    private T data;

    public static <T> RetMsg<T> empty(){
        RetMsg<T> msg = new RetMsg<>();
        msg.setRetNo(0);
        msg.setResMsg("no resp");
        return msg;
    }

    public Integer getRetNo() {
        return retNo;
    }

    public void setRetNo(Integer retNo) {
        this.retNo = retNo;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RetMsg{" +
                "retNo=" + retNo +
                ", resMsg='" + resMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
