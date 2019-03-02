package com.jnshu.test;

import org.junit.Test;

import java.util.Arrays;

public class CharTest {

    @Test
    public void test() {
//        char acher = 'a';
//        char enterCher = '\r';
//        char ch = '\u9999';
//        System.out.println(acher);
//        System.out.println(enterCher);
//        System.out.println(ch);
//
//        char zhong = '一';
//
//        int zhongValue = zhong;
//
//        System.out.println(zhong);
//        System.out.println(zhongValue);


//        System.out.println(c);

        String greeting = "Hello";
        int n = greeting.length();
        System.out.println(n);

        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);

        char first = greeting.charAt(0);
        char last = greeting.charAt(4);

        System.out.println("first = " + first);
        System.out.println("last = " + last);

        int index = greeting.offsetByCodePoints(2, 0);
        int cp = greeting.codePointAt(index);

        System.out.println("index = " + index + "cp = " + cp);

        char ch = 108;
        System.out.println(ch);

        int[] codePoints = greeting.codePoints().toArray();
        System.out.println(codePoints);
        String str = Arrays.toString(codePoints);
        System.out.println(str);


        char test = 65535;
        Character character = new Character(test);
        Integer integer = new Integer(10);

//        character = "100";

//        char test1 = '\u200000';
//        System.out.println(" test 1 = " + test1);
    }

    @Test
    public void test2(){
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);


    }

    @Test
    public void test3(){
        out:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i = " + i + " ; j = " + j);

                if (j == 2){
                    break out;
                }
            }
        }
    }



    @Test
    public void test4(){
        int[] array = {0,1,2};
        System.out.println(array);
    }
}
