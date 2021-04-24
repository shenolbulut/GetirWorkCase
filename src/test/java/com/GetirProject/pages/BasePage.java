package com.GetirProject.pages;

import com.GetirProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {


    public BasePage(   ){PageFactory.initElements(Driver.get(), this);}

    /**
     * this method gives you the element of tabs like "Türkçe, Giriş yap, Profil ex."
     *
     * @param tabName
     *
     * @return WebElement
     */
    public WebElement switchFromTab(String tabName){
        String locator="//*[contains(@class,'style__Wrapper-sc')][contains(.,'"+tabName+"')]";

        return Driver.get().findElement(By.xpath(locator));
    }


    public abstract String getTitle();
    public abstract String getHeader();








}
