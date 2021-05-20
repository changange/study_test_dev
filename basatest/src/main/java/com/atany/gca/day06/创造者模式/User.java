package com.atany.gca.day06.创造者模式;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Author：耿常安
 * Date：2021-02-27-17:35
 * Description：<描述>
 */
@Data
public class User {
    private String name;
    private int age;
    private char sex;
    private String pwd;
    private String ip;
    private Timestamp birthday;

    public User() {
    }

    public User(Builder builder){
        this.name = builder.name;
        this.age=builder.age;
        this.ip = builder.ip;
        this.sex = builder.sex;
        this.pwd = builder.pwd;
        this.birthday = builder.birthday;
    }

    //建造者
    public static class Builder{
        private String name;
        private int age;
        private char sex;
        private String pwd;
        private String ip;
        private Timestamp birthday;

        public static Builder of(){
            return new Builder();
        }

        public User build(){
            return new User(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(char sex) {
            this.sex = sex;
            return this;
        }

        public Builder pwd(String pwd) {
            this.pwd = pwd;
            return this;
        }

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder birthday(Timestamp birthday) {
            this.birthday = birthday;
            return this;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", pwd='" + pwd + '\'' +
                ", ip='" + ip + '\'' +
                ", birthday=" + birthday +
                '}';
    }

}
