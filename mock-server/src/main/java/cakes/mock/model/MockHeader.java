package cakes.mock.model;

/**
 * Author：耿常安
 * Date：2021-04-07-22:57
 * Description： 透传
 */
public class MockHeader {
    private String contentTupe;     //from,json等等
    private String methodType;

    public String getContentTupe() {
        return contentTupe;
    }

    public void setContentTupe(String contentTupe) {
        this.contentTupe = contentTupe;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    @Override
    public String toString() {
        return "MockHeader{" +
                "contentTupe='" + contentTupe + '\'' +
                ", methodType='" + methodType + '\'' +
                '}';
    }
}
