package com.ucodeacademy.practice;

import org.junit.*;



public class JUniteAnnotations {

    @Before // from JUnit 4
    public void beforeEachTest(){ // this method runs before each @Test/method
        System.out.println("I run before each test");
    }


    @BeforeClass
    public static void beforeClass(){
        System.out.println("I run before each class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("I run after class");
    }

    @Ignore
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(timeout = 2000)
    public void test3() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Test 3");
        //Thread.sleep(3000);
    }
}
