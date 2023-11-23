package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.SmartBearLoginPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SmartBearStepDef {

    SmartBearLoginPage loginPage = new SmartBearLoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("smartBearUrl"));
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        // entering username, password, and clicking on login button manually
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);


        // calling custom method form SmartBearLoginPage to login
        //loginPage.login(username, password);


    }
    @When("User Clicks on login button")
    public void user_clicks_on_login_button() {

        loginPage.loginButton.click();
    }
    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("weborders"));
        Driver.quitDriver();

    }

    @Then("User sees all orders")
    public void user_sees_all_orders() {
        // driver.getTitle() -> we used to do this way
        // Driver.getDriver() == driver
        String actualTile = Driver.getDriver().getTitle();

        // to fail the test on purpose add (!), so we can run it from FailedTestRunner class
        Assert.assertTrue("Title does not Contain",actualTile.contains("Web Orders"));

        Driver.quitDriver();
    }



}
