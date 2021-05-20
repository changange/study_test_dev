package com.atany.gca.day06.创造者模式;

import lombok.Builder;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Author：耿常安
 * Date：2021-02-27-20:50
 * Description：<描述>
 */

@Builder
@ToString
public class User2 {
    private String name;
    private int age;
    private char sex;
    private String pwd;
    private String ip;
    private Timestamp birthday;
}
