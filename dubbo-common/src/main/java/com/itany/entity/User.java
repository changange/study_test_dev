package com.itany.entity;

import java.io.Serializable;

/**
 * Author：耿常安
 * Date：2021-03-17-22:44
 * Description：<描述>
 */
public class User implements Serializable {
    private Integer id;
    private String usernmae;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usernmae='" + usernmae + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
