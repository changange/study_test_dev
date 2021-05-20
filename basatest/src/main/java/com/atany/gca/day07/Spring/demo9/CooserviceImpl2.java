package com.atany.gca.day07.Spring.demo9;

import org.springframework.stereotype.Component;

/**
 * Author：耿常安
 * Date：2021-02-28-15:09
 * Description：<描述>
 */

@Component      //这个类交给spring管理
public class CooserviceImpl2 implements CooService {
    @Override
    public void coo() {
        System.out.println("CooserviceImpl2.coo");
    }
}
