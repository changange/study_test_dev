package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-01-30-16:24
 * Description：<描述>
 */
public interface UserDao {
    /*
        添加用户
     */
    public void insertUser(User user);

    /**
     * 添加用户，返回主键
     */
    public void insert(User user);

    /**
     * 修改用户
     */
    public void updateUser(User user);

    /**
     * 删除用户
     */
    public void deleteById(Integer id);

    /**
     * 查询用户
     */
    public User selectById(Integer id);

    public List<User> selectAll();

    public User selectById2(Integer id);
    public User selectById3(Integer id);
    //多参数查询 使用索引
    public User selectByUsernameAndPassword(String username,String password);


    //多参数查询，使用注解
    public User selectByUsernameAndPassword2(@Param("username") String username, @Param("password") String password);

    //多参数查询，参数传入user对象里
    public User selectByUsernameAndPassword3(User user);

    //多参数查询，参数传一个map集合
    public User selectByUsernameAndPassword4(Map<String,Object> map);

    //模糊查询1
    public List<User> selectByUsername(String Username);

    //模糊查询2
    public List<User> selectByUsername2(String Username);

    //动态SQL if
    public List<User> selectByParams(User user);

    //动态SQL choose
    public List<User> selectByParams2(User user);

    //动态SQL where
    public List<User> selectByParams3(User user);

    //动态SQL set
    public void updateUser2(User user);

    //动态SQL trim
    public List<User> selectByParams4(User user);

    //动态SQL trim
    public void updateUser3(User user);

    //动态SQL foreach
    public List<User> selectByIds(List<Integer> ids);
}
