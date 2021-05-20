package com.atany.gca.day09.mybatid.责任链.demo2;

import com.atany.gca.day09.mybatid.责任链.MyFile;

/**
 * Author：耿常安
 * Date：2021-03-08-22:25
 * Description：<描述>
 */
public class ParseManager {
    private AbstractParse<MyFile> parse;
    private ParseManager(){
        parse = init();
    }

    public AbstractParse<MyFile> init(){
        MP4Parse mp4Parse = new MP4Parse();
        PNGParse pngParse = new PNGParse();
        AVIParse aviParse = new AVIParse();

        mp4Parse.addNextParse(pngParse);
        pngParse.addNextParse(aviParse);
        return mp4Parse;
    }

    public void parse(MyFile file){
        parse.parse(file);
    }

    private static class ClassHolder{
        private static final ParseManager INSTANCE = new ParseManager();

    }

    public static ParseManager of(){
        return ClassHolder.INSTANCE;
    }
}
