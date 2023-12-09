package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.AddRemoveElementsPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Waits;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddRemoveElementStepDef {

    AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();
    // get url from config.properties and store in a string
    String url = ConfigReader.getProperty("url");


    @Given("User is on the internet home page")
    public void user_is_on_the_internet_home_page() {

        Driver.getDriver().get(url);


    }
    @When("User clicks on addRemove element button")
    public void user_clicks_on_add_remove_element_button() {
        //addRemoveElementsPage.addRemoveButton.click();

        // We are using clickOn from Parent class, which takes care of explicit wait
        addRemoveElementsPage.clickOn(addRemoveElementsPage.addRemoveButton);


    }
    @When("User clicks on Added element button")
    public void user_clicks_on_added_element_button() {
       // addRemoveElementsPage.addButton.click();

        // We are using clickOn from Parent class, which takes care of explicit wait
        addRemoveElementsPage.clickOn(addRemoveElementsPage.addButton);

    }
    @Then("A new button should be displayed")
    public void a_new_button_should_be_displayed() {

        //Assert.assertTrue(addRemoveElementsPage.deleteButton.isDisplayed());

        // We are using iisElementDisplayed from Parent class
        Assert.assertTrue(addRemoveElementsPage.isElementDisplayed(addRemoveElementsPage.deleteButton));

    }
    @Then("User click on Delete button")
    public void user_click_on_delete_button() {
        //addRemoveElementsPage.deleteButton.click();

        // We are using clickOn from Parent class, which takes care of explicit wait
        addRemoveElementsPage.clickOn(addRemoveElementsPage.deleteButton);

    }
    @Then("Element should be deleted")
    public void element_should_be_deleted() {
        // use ! to make not true
        //Assert.assertTrue(!addRemoveElementsPage.deleteButton.isDisplayed());

        // to verify delete button is Not displayed

        try {

            //Assert.assertFalse(addRemoveElementsPage.deleteButton.isDisplayed());

            // We are using iisElementDisplayed from Parent class
            Assert.assertTrue(addRemoveElementsPage.isElementDisplayed(addRemoveElementsPage.deleteButton));

        } catch (Exception e){
            e.getStackTrace();
            System.out.println("Delete button is not displayed");
        }

        //Waits.wait(15);

        // made wait instance in Wait class, and inherit it from BasePage class
        addRemoveElementsPage.wait(15);
        Driver.quitDriver();

    }

}
