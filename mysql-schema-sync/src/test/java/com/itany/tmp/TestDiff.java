package com.itany.tmp;

import com.google.common.collect.Sets;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Author：耿常安
 * Date：2021-03-12-22:07
 * Description：<描述>
 */
public class TestDiff {
    
    @Test
    public void testDiff(){
        //从list1拿数据去list2去对比，没有的打印出来
        ArrayList<String> list1 = Lists.newArrayList("asd", "dsads", "123", "hch", "hcass");
        ArrayList<String> list2 = Lists.newArrayList("cahnans", "zhongg", "243", "hch", "hcass");

        Set<String> ss = Sets.difference(new HashSet<>(list1), new HashSet<>(list2)).immutableCopy();

        ss.forEach(System.out::println);
    }
}
