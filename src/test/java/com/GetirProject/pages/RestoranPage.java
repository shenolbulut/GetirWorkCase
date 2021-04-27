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

    @FindBy(xpath = "//article[contains(.,'Sepete git')]/div[3]/button")
    public WebElement sepeteGitButton;

    @FindBy(xpath = "//*[contains(.,'Lütfen seçim yapınız.')]")
    public WebElement birTerchiYapın;

    @FindBy(xpath = "//div/div/div/div/select")
    public List<WebElement> terchilerSelectTag;

    @FindBy(css = ".style__RadioWrapper-kjjl1a-2.fpjBvn")
    public List<WebElement> tercihlerRadioBttn;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> tercihlerimChekbox;

    @FindBy(xpath = "(//*[@data-index='2'])[2]")
    public WebElement kebap;





    /**
     * this method is about to solve the "sepete ekle" button. because some products have different
     *      choose which are mandatory to select. you cannot click without choosing that options.
     *      Some options are designed with dropdown(select tag), some are designed radio button and
     *      some are designed checkbox button and every product has different options also some products
     *      have not this options. so This method can handle all situations. Before "bir tercih yapın" alerts
     *      disappeared, method keeps going working.
     *
     * @param
     *
     * @return void
     */


    public void clickSepeteEkle() {
        BrowserUtils.waitForClickablility(sepeteEkleButton);

        while (birTerchiYapın.isDisplayed()) {

            try{
                for (WebElement element:terchilerSelectTag){
                    new Select(element).selectByIndex(2);

//                    for(int i=1; i<tercihlerimChekbox.size()+1; i++) {
//                        new Actions(Driver.get()).moveToElement(element).pause(2).click()
//                                .pause(2).perform();
//                        BrowserUtils.waitFor(4);
//
//                        new Actions(Driver.get()).moveToElement(Driver.get()
//                                .findElement(By.xpath("(//select)["+i+"]//option[2]")))
//                                .pause(2).click().perform();
//                        BrowserUtils.waitForClickablility(sepeteEkleButton);
//                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

                try {
                    for (WebElement elem : tercihlerRadioBttn) {
                        if (!elem.isSelected()) elem.click();
                        BrowserUtils.waitForClickablility(sepeteEkleButton);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    for (WebElement elm : tercihlerimChekbox) {
                        if (!elm.isSelected()) elm.click();
                        BrowserUtils.waitForClickablility(sepeteEkleButton);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }


}

