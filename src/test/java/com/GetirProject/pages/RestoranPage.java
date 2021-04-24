package com.GetirProject.pages;

import com.GetirProject.utilities.BrowserUtils;
import com.GetirProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

public class RestoranPage extends Dashboard{

    @FindBy(xpath = "//p[@contenteditable='false']")
    public WebElement firstProduct;

    @FindBy(xpath = "//button[contains(.,'Sepete Ekle')]")
    public WebElement sepeteEkleButton;

    @FindBy(xpath = "//button[contains(.,'Sepete git')]/..")
    public WebElement sepeteGitButton;

    @FindBy(xpath = "(//*[@class='style__Products-bj8eho-0 kiNHRJ']//span)[1]")
    public WebElement sepettekiUrunler;

    @FindBy(xpath = "(//*[@name='delete-1'])[1]")
    public WebElement deleteFromSepet;

    @FindBy(css = ".style__Wrapper-sc-6ivys6-1.haSjLq.style__OkButton-vk2nyz-8.gnGJVu")
    public WebElement deleteEvetBttn;

    @FindBy(xpath = "//*[contains(.,'Lütfen seçim yapınız.')]")
    public WebElement birTerchiYapın;

    @FindBy(xpath = "//*[@data-testid='select']")
    public List<WebElement> terchilerSelectTag;

    @FindBy(css = ".style__RadioWrapper-kjjl1a-2.fpjBvn")
    public List<WebElement> tercihlerRadioBttn;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> tercihlerimChekbox;






    public boolean compareTheProduct(String prodText){
        BrowserUtils.waitFor(2);
            if(sepettekiUrunler.getText().toLowerCase().contains(prodText.toLowerCase())) {
                return true;
            }else return false;
    }

    public void clickSepeteEkle(){
        BrowserUtils.waitForClickablility(sepeteEkleButton);

        while (birTerchiYapın.isDisplayed()){
            try{
                for (WebElement element:terchilerSelectTag){
                    //new Select(element).selectByIndex(2);
                    for(int i=1; i<tercihlerimChekbox.size()+1; i++) {
                        new Actions(Driver.get()).moveToElement(element).pause(2).click()
                                .pause(1).moveToElement(Driver.get()
                                .findElement(By.xpath("//select["+i+"]//option[2]")))
                                .pause(1).click().pause(1).perform();
                    }
                }
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }

            try{
                for (WebElement element:tercihlerRadioBttn){
                    if(!element.isSelected())element.click();
                }
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
            try {
                for(WebElement element:tercihlerimChekbox){
                    if(!element.isSelected())element.click();
                }
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
            BrowserUtils.waitForClickablility(sepeteEkleButton);
        }
    }




}
