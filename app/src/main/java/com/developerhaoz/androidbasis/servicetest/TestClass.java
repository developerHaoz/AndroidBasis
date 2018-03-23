package com.developerhaoz.androidbasis.servicetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Haoz
 * @date 2018/3/21.
 */
public class TestClass implements Callable<Integer>{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String inputContent = in.nextLine();
        String str = "sdfsf sdf sdf";
        char[] inputArr = inputContent.toCharArray();
        int[] inputIntArr = new int[inputArr.length];
        int positionNotZero = 0;
        for (int i = 0; i < inputIntArr.length; i++) {
            if(inputIntArr[i] == positionNotZero){
                positionNotZero = i;
            }
        }
        Arrays.sort(inputArr);
        HashMap<String, Integer> hashMap = new HashMap();
        TestClass ctt = new TestClass();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
