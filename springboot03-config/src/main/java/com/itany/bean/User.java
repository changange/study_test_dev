package com.itany.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-03-17:49
 * Description：通过加载配置文件，为属性注入值
 */

//必须将当前类添加到容器中
@Component
//默认会读取全局配置文件，将当前类中的属性和配置文件的user进行绑定
@ConfigurationProperties(prefix = "user")    //如果通过@value注入值，这个就可以注释掉
public class User {
    // @Value("gca")
    private String username;
    // @Value("${user.age}")
    private Integer age;
    // @Value("${user.status}")
    private Boolean status;
    // @Value("${user.birthday}")
    private Date birthday;
    //@Value("${user.}")          //不支持复杂类型的封装注入
    private Address address;
    // @Value("${user.lists}")
    private List<String> lists;
    private Map<String,Object> maps;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", birthday=" + birthday +
                ", address=" + address +
                ", lists=" + lists +
                ", maps=" + maps +
                '}';
    }
}
