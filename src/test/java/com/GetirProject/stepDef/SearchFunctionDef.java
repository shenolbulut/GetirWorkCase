package com.GetirProject.stepDef;

import com.GetirProject.pages.MyPage;
import com.GetirProject.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;

import static org.junit.Assert.*;

public class SearchFunctionDef {


    String searchItem;

    @When("the user enters search item {string} int the search button")
    public void the_user_enters_search_item_int_the_search_button(String item) {
        BrowserUtils.waitFor(5);
        searchItem=item.substring(0,item.length()-2);
        boolean staleElemet=true;
        while(staleElemet){
            try{
                new MyPage().searchButton.sendKeys(item);
                staleElemet=false;
            }catch (StaleElementReferenceException e){
                e.printStackTrace();
            }
        }
    }

    @Then("all the results has to be related with search item")
    public void all_the_results_has_to_be_related_with_search_item() {
        BrowserUtils.waitFor(5);
        assertTrue(new MyPage().checkTheResults(searchItem));
    }





}
