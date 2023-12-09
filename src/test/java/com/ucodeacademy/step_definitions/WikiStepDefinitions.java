package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.WikiPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Waits;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiStepDefinitions {

    WikiPage wikiPage = new WikiPage();

    @Given("User is on wiki home page")
    public void user_is_on_wiki_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("wiki.url"));
        new Waits().wait(3);

    }
    @Given("User types {string} in search box")
    public void user_types_in_search_box(String searchValue) {

        wikiPage.searchBox.sendKeys(searchValue );
        new Waits().wait(3);

        wikiPage.searchButton.click();

        new Waits().wait(3);


    }
    @Then("User sees {string} in the title")
    public void user_sees_in_the_title(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }
    @Then("User sees {string} in the main header")
    public void user_sees_in_the_main_header(String expectedHeader) {

        String actualHeader = wikiPage.searchHeader.getText();

        Assert.assertEquals("Failed header does not match", expectedHeader, actualHeader);

    }
    @Then("User sees {string} in the image header")
    public void user_sees_in_the_image_header(String expectedImageHeader) {
        String actualImageHeader = wikiPage.imageHeader.getText();
        Assert.assertEquals(expectedImageHeader,actualImageHeader);

        Driver.quitDriver();

    }

}
