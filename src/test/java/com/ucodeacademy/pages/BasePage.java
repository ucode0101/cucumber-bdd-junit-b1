package com.ucodeacademy.pages;

import com.ucodeacademy.utility.Driver;
import com.ucodeacademy.utility.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends Waits {


    Actions actions = new Actions(Driver.getDriver());



    public  void clickOn(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void enterUsernameAndPwd(WebElement usernameInput, WebElement pwdInput, String username,  String password){

        //wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);

        //wait.until(ExpectedConditions.visibilityOf(pwdInput)).sendKeys(password);
        // calling sendKey method
        sendKey(usernameInput, username);
        sendKey(pwdInput, password);

    }

    public String getTitleOfThePage(){
        return Driver.getDriver().getTitle();
    }

    public String getCurrentUrl(){
        return Driver.getDriver().getCurrentUrl();
    }

    public void sendKey(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public String getTextOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void moveToGivenElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

        actions.moveToElement(element).perform();

    }



}
