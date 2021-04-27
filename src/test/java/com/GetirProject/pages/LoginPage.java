package com.GetirProject.pages;

import com.GetirProject.utilities.BrowserUtils;
import com.GetirProject.utilities.ConfigurationReader;
import com.GetirProject.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Dashboard {


    @FindBy(xpath = "(//span[contains(.,'Getir şifresi ile')])[2]")
    public WebElement getirSifresiIle;

    @FindBy(xpath = "(//input[@name='gsm'])[2]")
    public WebElement phoneInfo;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement submitButton;


    /**
     * this method is about full step of login function. I am using this in Backround in other cases
     *
     * @param
     *
     * @return
     */

    public void login(){
        new Dashboard().acceptThecookis();
        String phoneNumber= ConfigurationReader.get("phoneNumber");
        new Dashboard().switchFromTab("Giriş yap").click();
        getirSifresiIle.click();
        phoneInfo.sendKeys(phoneNumber);
        password.sendKeys(ConfigurationReader.get("getirSifresi"));
        submitButton.click();
        BrowserUtils.waitFor(5);

    }


}
