package com.atany.gca.day09.mybatid.策略模式;

import com.atany.gca.day09.mybatid.责任链.MyFile;

/**
 * Author：耿常安
 * Date：2021-03-09-8:42
 * Description：<描述>
 */
public interface FileParser {

    void parse(MyFile file);
}
