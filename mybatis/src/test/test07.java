package test;

import dao.DeptDao;
import entity.Dept;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-01-31-16:57
 * Description：<描述>
 */
public class test07 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();

            //多对一
            //EmpDao empDao = session.getMapper(EmpDao.class);
            //List<Emp> emps = empDao.selectAll();
            //System.out.println(emps);


            //一对多
            DeptDao deptDao = session.getMapper(DeptDao.class);
            List<Dept> depts = deptDao.selectAll();
            System.out.println(depts);


            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.close();
        }
    }
}
