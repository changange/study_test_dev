package test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserMapper;
import entity.User;
import entity.UserExample;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

public class Test03 {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();

            UserMapper userMapper = session.getMapper(UserMapper.class);

            // 1.配置分页信息，指定页码、页大小
            int pageNum=2;
            int pageSize=4;
            PageHelper.startPage(pageNum,pageSize);

            // 2.获取原始数据
            List<User> users = userMapper.selectByExample(new UserExample());
            // System.out.println(users);
            // for (User user:users){
            //     System.out.println(user);
            // }

            // 3.将原始数据封装成分页数据
            PageInfo<User> pageInfo=new PageInfo<>(users);
            System.out.println(pageInfo);

            System.out.println("页码："+pageInfo.getPageNum());
            System.out.println("页大小："+pageInfo.getPageSize());
            System.out.println("总页数："+pageInfo.getPages());
            System.out.println("总条数："+pageInfo.getTotal());


            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            MyBatisUtil.close();
        }
    }
}
