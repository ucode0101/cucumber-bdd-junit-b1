package com.ucodeacademy.practice;

import org.junit.Ignore;
import org.junit.Test;


public class JunitAnnotations2 {


    @Ignore
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
}
