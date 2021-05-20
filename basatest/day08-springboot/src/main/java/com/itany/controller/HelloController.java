package com.itany.controller;

import com.itany.mvc.entity.ResultMsg;
import com.itany.mvc.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Author：耿常安
 * Date：2021-03-06-14:50
 * Description：<描述>
 */
@RestController    //@Controller+@ResponseBody
//@RequestMapping("/anan")
//@Controller
//@ResponseBody
@Slf4j
public class HelloController {

    /**
     * @RequestParam(Reifier = true)
     * required=true    参数必须要传，不然就报错了
     * defaultValue：默认值
     * value = "sname"：规定页面访问的参数必须是 sname，如果些其他的参数，就是一个默认值  anan
     */
    @RequestMapping("/hello")
    public String hi(@RequestParam(required = true,defaultValue = "anan", value = "sname") String name){
        return "hi," +name;
    }

    //返回json
    @RequestMapping("/msg")
    public ResultMsg demo1(String name){

        ResultMsg msg = ResultMsg.success();
        return msg;
    }

    /**
     *
     * @param student
     * @return
     *  接受的参数是json
     *  method = RequestMethod.POST ：限定请求方式是POST    这里不写就是不限制
     *  @RequestBody的作用其实是将json格式的数据转为java对象
     */
    @RequestMapping(value= "/student",method = RequestMethod.POST)
    public ResultMsg demo2(@RequestBody Student student){
        log.info("studnet()",student);
        ResultMsg msg = ResultMsg.success(student);
        return msg;
    }

    /**
     * xxxx?id=1
     * xxx/1
     *
     * {sid}：接受参数
     *
     * @PathVariable("sid")和/msg/{sid} 里边的sid要对应上
     */
    @RequestMapping("/msg/{sid}")
    public ResultMsg demo1(@PathVariable("sid") int id){
        Student student = new Student();
        student.setName("tom");
        student.setId(id);
        ResultMsg msg = ResultMsg.success(student);
        return msg;
    }
}
