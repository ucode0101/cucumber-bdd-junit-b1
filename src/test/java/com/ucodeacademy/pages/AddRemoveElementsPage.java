package com.ucodeacademy.pages;

import com.ucodeacademy.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage {
    public AddRemoveElementsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Add/Remove Elements']")
    public WebElement addRemoveButton;

    @FindBy(xpath = "//button[@onclick='addElement()']")
    public WebElement addButton;

    @FindBy(xpath = "//button[@class='added-manually']")
    public WebElement deleteButton;


}
