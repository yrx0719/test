package com.jnshu.collection.set;


import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class SetTest {


    @Test
    public void testHashSet() {
        Set hashset = new HashSet();
        //增加
        System.out.println("test add =================================");
        hashset.add("test0");
        hashset.add("test1");
        hashset.add("test2");
        System.out.println("hashSet = " + hashset);
        //迭代器
        System.out.println("test iterator===============================");
        Iterator iterator = hashset.iterator();
        while (iterator.hasNext()){
            String test = (String) iterator.next();
            System.out.println(test);
        }
        //删除单个元素
        System.out.println("test remove ==============================");
        hashset.remove("test1");
        System.out.println("hashSet = " + hashset);

        //删除所有
        System.out.println("test  addall ==============================  ");
        Set hashset1 = new HashSet();

        hashset1.add("test3");
        hashset1.add("test4");
        hashset1.add("test5");
        System.out.println("hashSet1 = " + hashset1);
        hashset.addAll(hashset1);
        System.out.println("hashSet = " + hashset);

        System.out.println("test remove all ===========================");
        hashset.removeAll(hashset1);
        System.out.println("hashset = " + hashset);


        hashset.forEach(obj -> System.out.println("name" + obj));
    }

    @Test
    public void testEquals() {
        //set 比价大小是比较他们的的equals()方法和hashCode()值
        Set hashSet0 = new HashSet();
        Set hashSet1 = new HashSet();

        hashSet0.add("test1");
        hashSet0.add("test2");
        hashSet0.add("test3");

        hashSet1.add("test1");
        hashSet1.add("test2");
        hashSet1.add("test3");

        System.out.println(hashSet0.equals(hashSet1));
        System.out.println(hashSet0.hashCode());
        System.out.println(hashSet1.hashCode());

        //错误的改写equals和hashcode方法
        //1.当equals方法返回true时,hashcode不同的话,两个相同的对象则保存在不同的hash表中位置,违反了set的规则;
        //2.当hashCode不同时,表示是不同的对象,equals为true,不符合实际,
    }

    @Test
    public void testEquals1(){
        class A {
            public boolean equals(Object obj){
                return true;
            }
        }

        class B {
            public int hashCode(){
                return 1;
            }
        }

        class C {
            public int hashCode() {
                return 2;
            }

            public boolean equals(Object obj){
                return true;
            }
        }


        HashSet hashSet = new HashSet();
        hashSet.add(new A());
        hashSet.add(new A());
        hashSet.add(new B());
        hashSet.add(new B());
        hashSet.add(new C());
        hashSet.add(new C());
        System.out.println("相等性测试" +  hashSet + ", 集合大小为: " + hashSet.size());

    }



    @Test
    public void testLinkedHashSet(){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashSet hashSet = new HashSet();

        //添加效率
        //LinkedHashSet
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100 * 10000; i++) {
            linkedHashSet.add(i);
        }
        Long LinkedHashSetTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedHashSet花费时间 = " + LinkedHashSetTime + "ms");

        //HashSet
        Long hashsetStartTime = System.currentTimeMillis();
        for (int i = 0; i < 100 * 10000; i++) {
            hashSet.add(i);
        }
        Long HashSetTime = System.currentTimeMillis() - hashsetStartTime;
        System.out.println("HashSet花费时间 = " + HashSetTime + "ms");


        //迭代效率
        startTime = System.currentTimeMillis();
        Iterator linkedHashSetIt = linkedHashSet.iterator();
        while (linkedHashSetIt.hasNext()){
            Integer test = (Integer) linkedHashSetIt.next();
        }
        Long linkedHashSetTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        Iterator hashSetIt = hashSet.iterator();
        while (hashSetIt.hasNext()){
            Integer test = (Integer) hashSetIt.next();
        }
        Long hashSetTime = System.currentTimeMillis() - startTime;

        System.out.println("迭代效率 : linkedHashSet = " + linkedHashSetTime  + " ; hashSet = " + hashSetTime);

    }
}

