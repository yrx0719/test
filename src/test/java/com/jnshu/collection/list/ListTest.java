package com.jnshu.collection.list;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    List list;
    @Test
    public void testList(){

        ArrayList arrayList = new ArrayList();
        arrayList.add("test0");
        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");
        arrayList.add("test4");
        System.out.println("0 = " + arrayList);

        arrayList.add(0,"test5");
        System.out.println("1 = " + arrayList);

        arrayList.set(0,"test0.5");
        System.out.println("2 = " + arrayList);

        Integer number = arrayList.indexOf("test4");
        System.out.println("3 = " + number);

        List arrayList1 = arrayList.subList(2,5);
        System.out.println("4 = " + arrayList1);

        Object arrayList2 = arrayList.get(3);
        System.out.println("5 = " + arrayList2);

    }

    @Test
    public void testLinkedList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("test0");
        linkedList.add("test1");
        linkedList.add("test2");
        linkedList.add("test3");
        linkedList.add("test4");
        System.out.println("0 = " + linkedList);

        linkedList.offer("test5");
        System.out.println("1 = " + linkedList);

        linkedList.push("test6");
        System.out.println("2 = " + linkedList);

        linkedList.pop();
        System.out.println("3 =" + linkedList);

        linkedList.pollLast();
        System.out.println("4 =" + linkedList);


    }

    @Test
    public void testList1(){
        ArrayList arrayList = new ArrayList();
        Vector vector = new Vector();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        LinkedList linkedList = new LinkedList();

        //添加效率
        //arrayList
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10000; i++) {
            arrayList.add(i);
        }
        Long arrayListTime = System.currentTimeMillis() - startTime;
//        System.out.println("arrayListTime花费时间 = " + arrayListTime + "ms");

        //linkedList
        Long linkedListStartTime = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10000; i++) {
            linkedList.add(i);
        }
        Long linkedListTime = System.currentTimeMillis() - linkedListStartTime;
//        System.out.println("linkedListTime花费时间 = " + linkedListTime + "ms");

        //copyOnWriteArrayList
        Long copyOnWriteArrayListstartTime = System.currentTimeMillis();
        for (int i = 0; i < 1 * 10000; i++) {
            copyOnWriteArrayList.add(i);
        }
        Long copyOnWriteArrayListTime = System.currentTimeMillis() - copyOnWriteArrayListstartTime;
        System.out.println("添加效率 : " + "arrayListTime花费时间 = " + arrayListTime + "ms ; " + "linkedListTime花费时间 = " + linkedListTime + "ms ; " +"copyOnWriteArrayListTime花费时间 = " + copyOnWriteArrayListTime + "ms");


        //迭代效率
        //arrayListIt
        startTime = System.currentTimeMillis();
        Iterator arrayListIt = arrayList.iterator();
        while (arrayListIt.hasNext()){
            Integer test = (Integer) arrayListIt.next();
//            System.out.println(test);
        }
        Long arrayListItTime = System.currentTimeMillis() - startTime;

        //LinkedList
        startTime = System.currentTimeMillis();
        Iterator LinkedListIt = linkedList.iterator();
        while (LinkedListIt.hasNext()){
            Integer test = (Integer) LinkedListIt.next();
//            System.out.println(test);
        }
        Long LinkedListTime = System.currentTimeMillis() - startTime;

        System.out.println("迭代效率 : arrayListIt = " + arrayListItTime  + " ; LinkedList = " + LinkedListTime);


        //插入效率
        //arraylist
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 0.1 * 10000; i++) {
             arrayList.add(100,i);
            
        }
        arrayListItTime = System.currentTimeMillis() - startTime;

        //LinkedList
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 0.1 * 10000; i++) {
             linkedList.add(100,i);
            
        }
        LinkedListTime = System.currentTimeMillis() - startTime;

        System.out.println("插入效率 : arrayListIt = " + arrayListItTime  + " ; LinkedList = " + LinkedListTime);

    }
}
