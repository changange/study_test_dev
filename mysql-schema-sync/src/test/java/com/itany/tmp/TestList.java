package com.itany.tmp;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Author：耿常安
 * Date：2021-03-12-22:15
 * Description：<描述>
 */
public class TestList {

    @Test
    public void test(){
        Aoo a1 = new Aoo(1, "cs");
        Aoo a2 = new Aoo(2, "sh");

        ArrayList<Aoo> aoos= Lists.newArrayList(a1,a2);
        Aoo a3 = new Aoo(2,"sh");

        System.out.println(aoos.contains(a3));  //false     true(重写equals)

        Set<Aoo> sets = new HashSet<>(aoos);
        System.out.println(sets.contains(a3));  //false     false(重写equals)
    }
}

class Aoo{
    private int id;
    private String name;

    public Aoo(int id, String name) {
        this.id = id;
        this.name = name;
    }
}