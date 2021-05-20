package dao;

import entity.Dept;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-31-14:55
 * Description：<描述>
 */
public interface DeptDao {

    public void insertDept(Dept dept);

    public Dept selectById(Integer id);
    //查询部门所有员工
    public List<Dept> selectAll();
}
