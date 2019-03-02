package com.jnshu.map;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    Map map;
    @Test
    public void testMap(){

        Map map = new HashMap();
        map.put("test0",0);
        map.put("test1",1);
        map.put("test2",2);
        map.put("test3",3);
        map.put("test4",4);
        map.put("test5",4);

        System.out.println("0 = " + map);

        Boolean success0 = map.containsKey("test0");
        Boolean success2 = map.containsKey("test");
        Boolean success1 = map.containsValue(0);
        Boolean success3 = map.containsValue(5);
        System.out.println("1 = " + success0  + success2);
        System.out.println("2 = " + success1  + success3);

        Object result = map.get("test1");
        System.out.println("3 = " + result);

        map.replace("test5",55);
        System.out.println("4 = " + map);

        map.remove("test5");
        System.out.println("5 =" + map);

        map.values();
        System.out.println("6 = " + map.values());

        map.keySet();
        System.out.println("7 =" + map.keySet());

    }

    @Test
    public void testMap1(){
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Hashtable hashtable = new Hashtable();

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        //添加效率
        //LinkedHashSet
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100 * 10000; i++) {
            hashMap.put(i,i);
        }
        Long hashMapTime = System.currentTimeMillis() - startTime;
        System.out.println("hashMap花费时间 = " + hashMapTime + "ms");

        //HashSet
        Long linkedHashMapStartTime = System.currentTimeMillis();
        for (int i = 0; i < 100 * 10000; i++) {
            linkedHashMap.put(i,i);
        }
        Long linkedHashMapTime = System.currentTimeMillis() - linkedHashMapStartTime;
        System.out.println("linkedHashMap花费时间 = " + linkedHashMapTime + "ms");


        //迭代效率
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10000; i++) {
            linkedHashMap.get(i);
        }
        Long linkedHashSetTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10000; i++) {
            hashMap.get(i);
        }
        Long hashSetTime = System.currentTimeMillis() - startTime;

        System.out.println("查询效率 : linkedHashMap = " + linkedHashSetTime  + " ; hashMap = " + hashSetTime);



    }
}
