package com.atany.gca.day09.mybatid.责任链.demo2;

/**
 * Author：耿常安
 * Date：2021-03-08-21:55
 * Description：<描述>
 */
public abstract class AbstractParse<T> {

    //下一个责任解析器
    private AbstractParse<T> nextPare;

    public void addNextParse(AbstractParse<T> nextPase){
        this.nextPare =nextPase;
    }

    /**
     *  判断是否能处理t，是否能解析文件
     * @param t
     * @return
     */
    public abstract boolean isDo(T t);

    /**
     * 如果能处理，怎么处理，处理方法
     * @param t
     */
    public abstract void doParse(T t);

    public void parse(T t){
        //先判断是否能够处理
        if(isDo(t)){
            //如果能处理就处理
            doParse(t);
        }

        //如果不能处理就给下一个人
        if(this.nextPare!=null){
            this.nextPare.parse(t);
        }
    }
}
