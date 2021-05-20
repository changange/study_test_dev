package com.atany.gca.day09.mybatid.责任链.demo2;

import com.atany.gca.day09.mybatid.责任链.FileType;
import com.atany.gca.day09.mybatid.责任链.MyFile;

/**
 * Author：耿常安
 * Date：2021-03-08-22:38
 * Description：<描述>
 */
public class App {
    public static void main(String[] args) {
        MyFile aa = MyFile.builder().fileName("aa").
                filePath("/gca/tt").fileType(FileType.MP4).build();
        ParseManager.of().parse(aa);
    }

}
