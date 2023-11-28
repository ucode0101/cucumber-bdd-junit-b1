package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.MerriamPage;
import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class MerriamStepDefinitions {
    MerriamPage page = new MerriamPage();
    public int counter=0;

    @When("User is on the merriam home page")
    public void user_is_on_the_merriam_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("merriam.url"));
    }
    @When("User locates and prints all texts of all links")
    public void user_locates_and_prints_all_texts_of_all_links() {

        for (WebElement eachElement : page.allLinks){
            System.out.println(eachElement.getText());
        }


    }
    @When("User prints how many links are missing texts")
    public void user_prints_how_many_links_are_missing_texts() {
        for (WebElement element : page.allLinks){
            String str = element.getText();
            // we want to remove all white spaces for empty string
            str = str.replaceAll(" ","");

            if (str.isEmpty()){
                counter++;
            }
        }
        System.out.println("links with missing text: "+counter);

    }
    @When("User prints how many link has text")
    public void user_prints_how_many_link_has_text() {
        int count=0;

        for (WebElement eachElement : page.allLinks){
            String str = eachElement.getText();
            // we want to remove all white spaces for empty string
            str = str.replaceAll(" ","");

            if (!str.isEmpty()){
                count++;
                System.out.println(eachElement.getText());
            }
        }
        System.out.println(count);

    }
    @When("User print how many total link")
    public void user_print_how_many_total_link() {
       int totalLinks = page.allLinks.size();
        System.out.println("Total Links: "+ totalLinks);
        Driver.quitDriver();
    }
}
