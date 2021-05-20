package com.itany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-06-10:32
 * Description：<描述>
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Map<String, Object>> findAll(){
        //这个可以直接传SQL，不用传rowMapper
        List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from t_user");

        //也可以这样写
        //String sql = "select * from t_user";
        //BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        //List<Map<String, Object>> users = jdbcTemplate.query(sql,rowMapper);


        return users;
    }
}
