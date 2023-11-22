package com.ucodeacademy.pages.herokuapp_pages;

import com.ucodeacademy.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage {

    public HoversPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Hovers']")
    public WebElement hoversButton;

    @FindBy(xpath = "(//div[@class='figure'])[1]")
    public WebElement image1;

    @FindBy(xpath = "(//div[@class='figure'])[2]")
    public WebElement image2;

    @FindBy(xpath = "(//div[@class='figure'])[3]")
    public WebElement image3;

    @FindBy(xpath = "(//div[@class='figcaption'])[1]")
    public WebElement user1;

    @FindBy(xpath = "(//div[@class='figcaption'])[2]")
    public WebElement user2;

    @FindBy(xpath = "(//div[@class='figcaption'])[3]")
    public WebElement user3;

}


