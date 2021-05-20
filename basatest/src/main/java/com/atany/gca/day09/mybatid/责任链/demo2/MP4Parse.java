package com.atany.gca.day09.mybatid.责任链.demo2;

import com.atany.gca.day09.mybatid.责任链.FileType;
import com.atany.gca.day09.mybatid.责任链.MyFile;

/**
 * Author：耿常安
 * Date：2021-03-08-22:22
 * Description：<描述>
 */
public class MP4Parse extends AbstractParse<MyFile>{
    @Override
    public boolean isDo(MyFile file) {
        return file.getFileType()== FileType.MP4;
    }

    @Override
    public void doParse(MyFile file) {
        System.out.println("MP4Parse.doParse");
    }
}
