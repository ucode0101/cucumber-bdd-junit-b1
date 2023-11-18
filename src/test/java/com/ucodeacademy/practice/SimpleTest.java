package com.ucodeacademy.practice;

import com.ucodeacademy.utility.DataReader;
import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Waits;
import org.junit.Test;

public class SimpleTest {

    @Test
    public void simpleTest(){

        String url = DataReader.getProperty("googleUrl");
        Driver.getDriver().get(url);

        Waits.wait(3);

        Driver.quitDriver();
    }
}
