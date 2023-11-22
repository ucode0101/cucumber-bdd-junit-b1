package com.ucodeacademy.step_definitions;

import com.ucodeacademy.pages.SearchDataTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;

import java.util.List;

public class SearchDataTableStepDef {
    SearchDataTablePage searchPage = new SearchDataTablePage();

    @Then("User searches for")
    public void user_searches_for(DataTable dataTable) {

        List<String> searchItem = dataTable.asList(String.class);

        for (String item : searchItem){
            searchPage.searchBox.sendKeys(item + Keys.ENTER);
        }



    }

}
