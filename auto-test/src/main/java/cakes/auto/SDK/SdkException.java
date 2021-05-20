package cakes.auto.SDK;

/**
 * Author：耿常安
 * Date：2021-04-01-22:41
 * Description：<描述>
 */
public class SdkException extends RuntimeException{
    public SdkException() {
        super();
    }

    public SdkException(String message) {
        super(message);
    }

    public SdkException(String message, Throwable cause) {
        super(message, cause);
    }

    public SdkException(Throwable cause) {
        super(cause);
    }

    protected SdkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
