package com.atany.gca.day09.mybatid.策略模式;

import com.atany.gca.day09.mybatid.责任链.FileType;
import com.atany.gca.day09.mybatid.责任链.MyFile;

/**
 * Author：耿常安
 * Date：2021-03-09-8:55
 * Description：<描述>
 */
public class APp {
    public static void main(String[] args) {
        MyFile aa = MyFile.builder().fileName("aa").filePath("/root/nv").fileType(FileType.AVI).build();
        ParserManager.of().parser(aa);
    }
}
