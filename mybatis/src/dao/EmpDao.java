package dao;

import entity.Emp;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-31-14:56
 * Description：<描述>
 */
public interface EmpDao {
    public void insertEmp(Emp emp);

    public List<Emp> selectAll();

    //一对多
}
