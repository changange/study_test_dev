package com.atany.gca.day07.Spring.demo3;

/**
 * Author：耿常安
 * Date：2021-02-27-22:01
 * Description：<描述>
 */

//交给spring去管理

import org.springframework.stereotype.Component;

/**
 * 相当于     <bean id="hello" class="XXXX"
 *Component 默认ID类名的小写   -》helloServiceImpl
 * @Component("gca"):指定ID
 */
// @Component("gca")
@Component()
public class HelloServiceImpl implements HelloService {
    @Override
    public String hi(String name) {
        System.out.println("HelloServiceImpl.hi");
        return "Hi:" + name;
    }
}
