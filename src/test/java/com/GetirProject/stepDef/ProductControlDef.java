package com.GetirProject.stepDef;

import com.GetirProject.pages.MyPage;
import com.GetirProject.pages.RestoranPage;
import com.GetirProject.pages.Sepetim;
import com.GetirProject.utilities.BrowserUtils;
import com.GetirProject.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;


import static org.junit.Assert.*;

public class ProductControlDef {

    String firstProdName;
    @Given("the user clicks one of the restroant")
    public void the_user_clicks_one_of_the_restroant() {
        new MyPage().profil.click();
        BrowserUtils.waitForClickablility(new MyPage().profilMenu("Favori Restoranlar"));
        BrowserUtils.waitFor(5);
        BrowserUtils.clickWithTimeOut(new MyPage().firstRestrount,10);
    }

    @Given("the user add a product to the packet")
    public void the_user_add_a_product_to_the_packet() {
        BrowserUtils.waitFor(5);
        firstProdName=new RestoranPage().firstProduct.getText();
        BrowserUtils.waitForClickablility(new RestoranPage().firstProduct);
        new RestoranPage().clickSepeteEkle();

    }

    @When("check the product on the packet")
    public void check_the_product_on_the_packet() {
        BrowserUtils.waitForClickablility(new RestoranPage().sepeteGitButton);
        BrowserUtils.waitFor(5);
        assertTrue(new RestoranPage().getTitle().contains("Sepetim"));
        assertTrue(firstProdName.contains(new Sepetim().sepettekiUrunler.getText()));
    }

    @When("thue user remove the product from packet")
    public void thue_user_remove_the_product_from_packet() {
        BrowserUtils.waitFor(5);
        BrowserUtils.waitForClickablility(new Sepetim().deleteFromSepet);
        BrowserUtils.waitForClickablility(new Sepetim().deleteEvetBttn);
        BrowserUtils.waitFor(5);
    }

    @Then("chek the packet is empity")
    public void chek_the_packet_is_empity() {
        assertTrue(new RestoranPage().getTitle().contains("GetirYemek"));
        BrowserUtils.waitFor(5);
    }


}
