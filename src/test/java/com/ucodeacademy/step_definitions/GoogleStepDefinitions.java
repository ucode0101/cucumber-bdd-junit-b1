package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.GoogleSearchPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {
    GoogleSearchPage searchPage = new GoogleSearchPage();

    @When("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

    }
    @When("User searches for {string}")
    public void user_searches_for(String keyword) {
        searchPage.searchBox.sendKeys(keyword + Keys.ENTER);

    }
    @Then("User should be able to sea {string} in the title")
    public void user_should_be_able_to_sea_in_the_title(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title does not Contain!",actualTitle.contains(expectedTitle));

        Driver.quitDriver();
    }

}
