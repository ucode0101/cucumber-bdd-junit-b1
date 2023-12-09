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
    // Actions actions = new Actions(Driver.getDriver());


    @Given("User click on Hovers button")
    public void user_click_on_hovers_button() {
        //hoversPage.hoversButton.click();

        hoversPage.clickOn(hoversPage.hoversButton);

    }

    @Given("User hovers each image and verify text is displayed")
    public void user_hovers_each_image_and_verify_text_is_displayed() {

       //actions.moveToElement(hoversPage.image1).perform();
        // calling moveToGivenElement from BasePage, which takes care of explicit wai, and hover
        hoversPage.moveToGivenElement(hoversPage.image1);

        Assert.assertTrue("Not displayed", hoversPage.isElementDisplayed(hoversPage.user1));

       // System.out.println(hoversPage.user1.getText());
        System.out.println(hoversPage.getTextOfElement(hoversPage.user1));

        //actions.moveToElement(hoversPage.image2).perform();

        // calling moveToGivenElement from BasePage, which takes care of explicit wai, and hover
        hoversPage.moveToGivenElement(hoversPage.image2);

        Assert.assertTrue(hoversPage.isElementDisplayed(hoversPage.user2));
       // System.out.println(hoversPage.user2.getText());

        System.out.println(hoversPage.getTextOfElement(hoversPage.user2));

        //actions.moveToElement(hoversPage.image3).perform();

        // calling moveToGivenElement from BasePage, which takes care of explicit wai, and hover
        hoversPage.moveToGivenElement(hoversPage.image3);

        //Assert.assertTrue("Text is not displayed", hoversPage.user3.isDisplayed());
        Assert.assertTrue("Text is not displayed", hoversPage.isElementDisplayed(hoversPage.user3));

       // System.out.println(hoversPage.user3.getText());
        System.out.println(hoversPage.getTextOfElement(hoversPage.user3));

        Driver.quitDriver();
    }

}
