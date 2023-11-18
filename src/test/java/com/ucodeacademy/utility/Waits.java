package com.ucodeacademy.utility;

public class Waits {

    public static void wait(int second){

        try {
            Thread.sleep((long) second * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
