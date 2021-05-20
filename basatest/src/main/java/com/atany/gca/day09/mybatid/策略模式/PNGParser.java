package com.atany.gca.day09.mybatid.策略模式;

import com.atany.gca.day09.mybatid.责任链.MyFile;

/**
 * Author：耿常安
 * Date：2021-03-09-8:44
 * Description：<描述>
 */
public class PNGParser  implements FileParser{

    @Override
    public void parse(MyFile file) {
        System.out.println("PNGParser.parse：" + file);
    }
}
