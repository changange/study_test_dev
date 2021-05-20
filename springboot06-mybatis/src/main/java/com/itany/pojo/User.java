package com.itany.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Author：耿常安
 * Date：2021-03-06-10:53
 * Description：lombok使用
 */

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data   //等价于上边四个
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
}
