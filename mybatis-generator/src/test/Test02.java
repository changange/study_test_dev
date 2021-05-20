package test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserMapper;
import entity.User;
import entity.UserExample;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

/**
 * Author：耿常安
 * Date：2021-02-01-8:42
 * Description：<描述>
 */
public class Test02 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();

            UserMapper userMapper = session.getMapper(UserMapper.class);
            //List<User> users = userMapper.selectByExample(new UserExample());

            //1、配置分页集合，指定页码，指定每页大小
            int pageNum = 2;
            int pageSize=4;
            PageHelper.startPage(pageNum,pageSize);

            //2、获取原始数据
            List<User> users1 = userMapper.selectByExample(new UserExample());
            //System.out.println(users1);

            //3、将原始数据封装成分页数据
            PageInfo<User> pageInfo = new PageInfo<>(users1);
            System.out.println(pageInfo);

            System.out.println("页码："+pageInfo.getPageNum());
            System.out.println("页大小："+pageInfo.getPageSize());
            System.out.println("总页数："+pageInfo.getPages());
            System.out.println("总条数："+pageInfo.getTotal());

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.close();
        }
    }
}
