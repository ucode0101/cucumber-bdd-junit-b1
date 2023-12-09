package com.ucodeacademy.practice;

import com.ucodeacademy.pages.GoogleSearchPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleSearch {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    // In this test, we will try to reproduce/recreate StaleElementReferenceException
    // by refreshing the page after locating the WebElement, and try to use that WebElement
    @Test
    public void staleElementReferenceException(){
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));


        WebElement searchBox = Driver.getDriver().findElement(By.id("APjFqb"));

        Driver.getDriver().navigate().refresh();

        // calling instance method through new
        new Waits().wait(2);
        searchBox.sendKeys("java"+ Keys.ENTER);
    }

    // In this test, we can/will avoid StaleElementReferenceException because we are using POM
    // Even by refreshing the page after locating the WebElement, it should work
    @Test
    public void staleElementReferenceException2(){

        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        Driver.getDriver().navigate().refresh();
        new Waits().wait(2);

        googleSearchPage.searchBox.sendKeys("java");

        Driver.getDriver().navigate().refresh();
        new Waits().wait(2);
        googleSearchPage.searchBox.sendKeys("JUnit");


    }
}
