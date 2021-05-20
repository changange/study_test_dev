package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-31-14:47
 * Description：<描述>
 */
public class Dept implements Serializable {
    private Integer id;
    private String name;

    //一个部门多个员工      一对多
    private List<Emp> emps = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept(String name) {
        this.name = name;
    }

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
