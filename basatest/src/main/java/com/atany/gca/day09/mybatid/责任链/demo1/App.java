package com.atany.gca.day09.mybatid.责任链.demo1;

import com.atany.gca.day09.mybatid.责任链.FileType;
import com.atany.gca.day09.mybatid.责任链.MyFile;

/**
 * Author：耿常安
 * Date：2021-03-08-21:29
 * Description：<描述>
 */
public class App {

    public static void main(String[] args) {
        MyFile aa = MyFile.builder().fileName("aa").
                filePath("/gca/tt").fileType(FileType.MP4).build();
        parse(aa);
    }

    public static void parse(MyFile file){
        if(file.getFileType()== FileType.MP4){
            new MP4Parse().parse(file);
        }else if(file.getFileType()==FileType.PNG){
            new PNGparse().parse(file);
        }
    }
}
