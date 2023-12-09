package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.ScenarioOutlinePage;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class ScenarioOutlineStepDef {

    ScenarioOutlinePage outlinePage = new ScenarioOutlinePage();

    @When("User searches for an {string}")
    public void user_searches_for_an(String itemName) {

        //outlinePage.searchBox.sendKeys(itemName + Keys.ENTER);

        // calling sendKey from Base class, that will take care of explicit wait
        outlinePage.sendKey(outlinePage.searchBox, itemName + Keys.ENTER);


    }
    @Then("User should see {string} in page title")
    public void user_should_see_in_page_title(String itemName) {
        //String actualTitle = Driver.getDriver().getTitle();

        String actualTitle = outlinePage.getTitleOfThePage();

        Assert.assertTrue(actualTitle.contains(itemName));
        Driver.quitDriver();

    }

}
