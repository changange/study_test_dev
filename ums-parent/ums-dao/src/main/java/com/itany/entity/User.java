package com.itany.entity;

import java.io.Serializable;

/**
 * Author：耿常安
 * Date：2021-01-29-18:09
 * Description：<描述>
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer age;

    public User() {

    }

    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
