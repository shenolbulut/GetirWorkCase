package com.GetirProject.stepDef;

import com.GetirProject.pages.MyPage;
import com.GetirProject.pages.RestoranPage;
import com.GetirProject.utilities.BrowserUtils;
import com.GetirProject.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class ProductControlDef {

    String firstProdName;
    @Given("the user clicks one of the restroant")
    public void the_user_clicks_one_of_the_restroant() {
        BrowserUtils.scrolToPage();
        BrowserUtils.clickWithTimeOut(new MyPage().firstRestrount,10);
    }

    @Given("the user add a product to the packet")
    public void the_user_add_a_product_to_the_packet() {
        BrowserUtils.waitFor(3);
        firstProdName=new RestoranPage().firstProduct.getText();

        BrowserUtils.clickWithTimeOut(new RestoranPage().firstProduct,10);

        BrowserUtils.waitFor(2);
        //BrowserUtils.clickWithTimeOut(new RestoranPage().sepeteEkleButton, 10);
        //BrowserUtils.clickWithJS(new RestoranPage().sepeteEkleButton);
        new Actions(Driver.get())
                .moveToElement(new RestoranPage().sepeteEkleButton).pause(1)
                .click().perform();

    }

    @When("check the product on the packet")
    public void check_the_product_on_the_packet() {
        BrowserUtils.waitFor(3);
        new Actions(Driver.get())
                .moveToElement(new RestoranPage().sepeteGitButton)
                .click().perform();
        BrowserUtils.waitFor(3);
        //BrowserUtils.clickWithTimeOut(new RestoranPage().sepeteGitButton, 10);
        assertTrue(new RestoranPage().getTitle().contains("Sepetim"));
        assertTrue(firstProdName.contains(new RestoranPage().sepettekiUrunler.getText()));
        BrowserUtils.waitFor(2);
    }

    @When("thue user remove the product from packet")
    public void thue_user_remove_the_product_from_packet() {
        BrowserUtils.clickWithTimeOut(new RestoranPage().deleteFromSepet, 10);
        BrowserUtils.waitFor(2);
        new Actions(Driver.get())
                .moveToElement(new RestoranPage().deleteEvetBttn)
                .click().perform();
        BrowserUtils.waitFor(2);
    }

    @Then("chek the packet is empity")
    public void chek_the_packet_is_empity() {
        assertTrue(new RestoranPage().getTitle().contains("GetirYemek"));
        BrowserUtils.waitFor(5);
    }


}
