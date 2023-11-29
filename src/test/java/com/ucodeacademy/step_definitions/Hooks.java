package com.ucodeacademy.step_definitions;

import com.ucodeacademy.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

//    @Before(order = 2)
//    public void beforeEachScenario(Scenario scenario){
//        System.out.println("I run before each Scenario 1");
//        System.out.println(scenario.getName());
//
//    }

    @Before(order = 1)
    public void beforeEachScenario2(Scenario scenario){
        System.out.println("I run before each Scenario 2");
        System.out.println(scenario.getName());

    }


//    @After(order = 19)
//    public void afterEachScenario(Scenario scenario){
//        System.out.println("I run after each Scenario 1");
//        System.out.println(scenario.getId());
//    }
//
//    @After(order = 11)
//    public void afterEachScenario2(Scenario scenario){
//        System.out.println("I run after each Scenario 2");
//        System.out.println(scenario.getId());
//    }
//
    @After
    public void screenshotOfFailedScenario(Scenario scenario){
        if (scenario.isFailed()){
            // Cast driver to TakesScreenshot take screenshot and store it  byte [] screenshot
            byte [] screenshot = ( (TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
    }
}
