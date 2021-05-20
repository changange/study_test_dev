package com.atany.gca.day07.Spring.demo6;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author：耿常安
 * Date：2021-02-27-22:01
 * Description：<描述>
 */

//交给spring去管理

/**
 * 相当于     <bean id="hello" class="XXXX"
 *Component 默认ID类名的小写   -》helloServiceImpl
 * @Component("gca"):指定ID
 */
@Component()
public class HelloServiceImpl implements HelloService {

    // Autowired默认只能通过类型去匹配
    // @Autowired      //这个属性spring帮我自动new     在实现类必须要有@Component注解

    // @Qualifier("cooserviceImpl2")       //通过ID去匹配  配合Autowired一起使用

    // @Resource         //什么也不写的时候先通过name找，再通过type找
                        //name就是 变量的别名  如：cooService
    // @Resource(type = CooService.class)    //通过类型去找
    @Resource(name="cooserviceImpl2")       //自动通过ID去找，如果ID找不到，就通过类型去找，如果类型找不到才抛异常
    private CooService cooService;

    @Override
    public String hi(String name) {

        cooService.coo();

        System.out.println("HelloServiceImpl4.hi");
        return "Hi:" + name;
    }
}
