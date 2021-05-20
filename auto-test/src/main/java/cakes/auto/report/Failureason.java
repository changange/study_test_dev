package cakes.auto.report;

/**
 * Author：耿常安
 * Date：2021-03-26-9:19
 * Description： 失败的用例
 */
public class Failureason {

    private String className;
    private String methodName;
    private String message;

    public Failureason() {
    }

    public Failureason(String className, String methodName, String message) {
        this.className = className;
        this.methodName = methodName;
        this.message = message;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Failureason{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
