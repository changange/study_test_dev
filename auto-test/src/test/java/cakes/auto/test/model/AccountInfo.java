package cakes.auto.test.model;

/**
 * Author：耿常安
 * Date：2021-03-27-19:43
 * Description：<描述>
 *     2
 */
public class AccountInfo {
    private String account;
    private String accountName;

    public AccountInfo() {
    }

    public AccountInfo(String account, String accountName) {
        this.account = account;
        this.accountName = accountName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "account='" + account + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
