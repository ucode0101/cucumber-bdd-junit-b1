package com.ucodeacademy.step_definitions.herokuapp_step_def;

import com.ucodeacademy.pages.herokuapp_pages.HoversPage;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class HoversStepDefinitions {
    HoversPage hoversPage = new HoversPage();
    Actions actions = new Actions(Driver.getDriver());


    @Given("User click on Hovers button")
    public void user_click_on_hovers_button() {
        hoversPage.hoversButton.click();

    }

    @Given("User hovers each image and verify text is displayed")
    public void user_hovers_each_image_and_verify_text_is_displayed() {
       actions.moveToElement(hoversPage.image1).perform();
        Assert.assertTrue("Not displayed", hoversPage.user1.isDisplayed());
        System.out.println(hoversPage.user1.getText());

        actions.moveToElement(hoversPage.image2).perform();
        Assert.assertTrue(hoversPage.user2.isDisplayed());
        System.out.println(hoversPage.user2.getText());

        actions.moveToElement(hoversPage.image3).perform();
        Assert.assertTrue("Text is not displayed", hoversPage.user3.isDisplayed());
        System.out.println(hoversPage.user3.getText());

        Driver.quitDriver();
    }

}
