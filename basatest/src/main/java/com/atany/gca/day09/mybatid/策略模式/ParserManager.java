package com.atany.gca.day09.mybatid.策略模式;


import com.atany.gca.day09.mybatid.责任链.FileType;
import com.atany.gca.day09.mybatid.责任链.MyFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Author：耿常安
 * Date：2021-03-09-8:47
 * Description：<描述>
 */
public class ParserManager {

    private Map<FileType, FileParser> map;

    private ParserManager(){
        map = new HashMap<>();
        map.put(FileType.PNG, new PNGParser());
        map.put(FileType.MP4, new MP4Parse());
        map.put(FileType.AVI, new AVIParser());

    }

    //解析
    public void parser(MyFile file){
        if(map.containsKey(file.getFileType())){
            map.get(file.getFileType()).parse(file);
        }
    }

    private static class ClassHolder{
        private static final ParserManager INSTANCE = new ParserManager();
    }

    public static ParserManager of(){
        return ClassHolder.INSTANCE;
    }
}
