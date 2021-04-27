package com.GetirProject.pages;

import com.GetirProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage {

    @FindBy(xpath = "//button[contains(.,'Tamam')]")
    public WebElement accept;

    @Override
    public String getTitle() {

        return Driver.get().getTitle();
    }

    @Override
    public String getHeader() {
        return Driver.get().findElement(By.tagName("header")).getText();
    }

    public void acceptThecookis(){
        try{
            accept.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
