package com.atany.gca.day11.监听器.demo1;


import com.atany.gca.day11.监听器.Tickket;

/**
 * Author：耿常安
 * Date：2021-03-16-10:34
 * Description：<描述>
 */
public class App {
    public static void main(String[] args) {
        Tickket tickket = new Tickket(100, "bc", "sh");
        new AirC().send(tickket);
    }
}
