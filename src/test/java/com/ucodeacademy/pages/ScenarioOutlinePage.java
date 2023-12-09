package com.ucodeacademy.pages;

import com.ucodeacademy.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScenarioOutlinePage extends BasePage {
    public ScenarioOutlinePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "APjFqb")
    public WebElement searchBox;
}
