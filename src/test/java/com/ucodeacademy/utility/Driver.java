package com.ucodeacademy.utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {
    private Driver(){

    }
//
//    private static WebDriver driver;


//    public static WebDriver getDriver(){
//
//        if (driver == null){
//
//            // to get the browser name from .properties file
//            String browserName = ConfigReader.getProperty("browser");
//            browserName = browserName.toLowerCase();
//
//            switch (browserName){
//                case "chrome":
//                    driver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    driver = new FirefoxDriver();
//                    break;
//                case "safari":
//                    driver = new SafariDriver();
//                    break;
//                case "edge":
//                    driver = new EdgeDriver();
//                    break;
//                case "chrome-headless":
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--headless");
//                    driver = new ChromeDriver(options);
//                    //driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
//                    break;
//
//                case "chrome-remote":
//                    DesiredCapabilities capabilities = new DesiredCapabilities();
//                    capabilities.setBrowserName("chrome");
//                    capabilities.setPlatform(Platform.ANY);
//                    try {
//
//                        URL url = new URL("http://localhost:4444/wd/hub");
//                        threadLocalDriver.set(new RemoteWebDriver(url,capabilities));
//
//                    } catch (Exception e){
//                        e.getStackTrace();
//                        throw new RuntimeException("Remote Web Driver is not working");
//                    }
//                default:
//                    driver = new ChromeDriver();
//            }
//
//
//        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        return driver;
//
//
//    }
//
//    public static void quitDriver(){
//        if (driver != null){
//            driver.quit();
//            driver = null;
//        }
//    }


    private static  ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        // Check if the threadLocalDriver has already been initialized for this thread
        if (threadLocalDriver.get() == null) {
            // If not initialized, create a new instance based on the browser name
            String browserName = ConfigReader.getProperty("browser").toLowerCase();

            switch (browserName) {
                case "chrome":
                    threadLocalDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    threadLocalDriver.set(new FirefoxDriver());
                    break;
                case "safari":
                    threadLocalDriver.set(new SafariDriver());
                    break;
                case "edge":
                    threadLocalDriver.set(new EdgeDriver());
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    threadLocalDriver.set(new ChromeDriver(options));
                    break;
                case "remote":

                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    capabilities.setPlatform(Platform.ANY);
                    try {

                        URL url = new URL("http://100.26.214.17:4444/wd/hub");

                        threadLocalDriver.set(new RemoteWebDriver(url,capabilities));

                    } catch (Exception e){
                        e.printStackTrace();

                        throw new RuntimeException("Remote Web Driver is not working");
                    }
                    break;

                default:
                    throw new RuntimeException("Invalid browser name");
            }
        }

        // Configure the WebDriver instance
        WebDriver driver = threadLocalDriver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    // Add a method to quit the WebDriver instance at the end of the test
    public static void quitDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit();
            // Remove the WebDriver instance from the ThreadLocal to avoid memory leaks
            threadLocalDriver.remove();
        }
    }


}
