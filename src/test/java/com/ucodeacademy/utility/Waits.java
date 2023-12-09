package com.ucodeacademy.utility;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void wait(int second){

        try {
            Thread.sleep((long) second * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
