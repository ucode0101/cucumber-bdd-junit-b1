package com.ucodeacademy.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver == null){

            // to get the browser name from .properties file
            String browserName = ConfigReader.getProperty("browser");
            browserName = browserName.toLowerCase();

            switch (browserName){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "chrome-headless":
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    driver = new ChromeDriver();
            }




        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
