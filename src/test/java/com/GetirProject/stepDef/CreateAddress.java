package com.GetirProject.stepDef;

import com.GetirProject.pages.Adreslerim;
import com.GetirProject.pages.MyPage;
import com.GetirProject.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import java.util.Map;

public class CreateAddress {

    @Given("the user click his profile")
    public void theUserClickHisProfile() {
       BrowserUtils.clickWithTimeOut(new MyPage().profil,15);
    }

    @And("the user choose a dropdown {string} from the list")
    public void theUserChooseADropdownFromTheList(String menu) {
        BrowserUtils.clickWithTimeOut(new MyPage().profilMenu(menu), 10);

    }

    @Then("the user should be able to create a new address from adderess type {string}")
    public void theUserShouldBeAbleToCreateANewAddressFromAdderessType(String addressType) {
        BrowserUtils.clickWithTimeOut(new Adreslerim().chooseAddress(addressType), 10);
    }

    @Then("the user should be able to create a new address")
    public void theUserShouldBeAbleToCreateANewAddress(Map<String, Object> addressDetail) {
        new Adreslerim().createAddress(addressDetail);
        assertTrue(new Adreslerim().confirmAddress((String) addressDetail.get("Adres")));

    }

}
