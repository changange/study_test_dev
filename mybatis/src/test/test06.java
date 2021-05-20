package test;

import dao.DeptDao;
import dao.EmpDao;
import entity.Dept;
import entity.Emp;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

/**
 * Author：耿常安
 * Date：2021-01-31-15:05
 * Description：<描述>
 */
public class test06 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();

            Dept d1= new Dept("研发部");
            Dept d2= new Dept("市场校验");
            Dept d3= new Dept("教学部");

            Emp e1 = new Emp("e1", 5000.0, d1);
            Emp e2 = new Emp("e2", 5000.0, d2);
            Emp e3 = new Emp("e3", 5000.0, d3);
            Emp e4 = new Emp("e4", 5000.0, d3);

            DeptDao deptDao = session.getMapper(DeptDao.class);
            EmpDao empDao = session.getMapper(EmpDao.class);

            deptDao.insertDept(d1);
            deptDao.insertDept(d2);
            deptDao.insertDept(d3);

            empDao.insertEmp(e1);
            empDao.insertEmp(e2);
            empDao.insertEmp(e3);
            empDao.insertEmp(e4);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.close();
        }
    }
}
