package com.GetirProject.stepDef;

import com.GetirProject.pages.Dashboard;
import com.GetirProject.pages.LoginPage;
import com.GetirProject.utilities.BrowserUtils;
import com.GetirProject.utilities.ConfigurationReader;
import com.GetirProject.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class LoginDef {
    @Given("the user is on the Base page")
    public void the_user_is_on_the_Base_page() {

        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String tab) {
     BrowserUtils.clickWithTimeOut(new Dashboard().switchFromTab(tab),10);
    }

    @And("the user clicks the getir password button")
    public void theUserClicksTheGetirPasswordButton() {
        BrowserUtils.clickWithTimeOut(new LoginPage().getirSifresiIle,10);
    }

    @And("the user enters  a valid phoneNumber")
    public void theUserEntersAValidPhoneNumber() {
        new LoginPage().phoneInfo.sendKeys(ConfigurationReader.get("phoneNumber"));
    }

    @And("the user enters the valid password")
    public void theUserEntersTheValidPassword() {
        new LoginPage().password.sendKeys(ConfigurationReader.get("getirSifresi"));
    }

    @And("the user clicks the submit button")
    public void theUserClicksTheSubmitButton() {

        BrowserUtils.clickWithTimeOut(new LoginPage().submitButton,10);

    }

    @Then("page title has to match this title {string}")
    public void pageTitleHasToMatchThisTitle(String title) {
        BrowserUtils.waitFor(4);
        assertEquals(title, Driver.get().getTitle());
    }

    @And("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        new LoginPage().login();
    }
}
