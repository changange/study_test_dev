package com.atany.gca.day07.Spring.demo9;

import org.springframework.beans.factory.annotation.Value;
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
@Component
public class HelloServiceImpl implements HelloService {

    @Value("嘻嘻 ")       //当个默认值
    private String alias;

    @Resource(name="cooserviceImpl2")       //自动通过ID去找，如果ID找不到，就通过类型去找，如果类型找不到才抛异常
    private CooService cooService;

    @Override
    public String hi(String name) {

        cooService.coo();

        System.out.println("HelloServiceImpl4.hi");
        return "Hi:" + name + "and" + alias;
    }
}
