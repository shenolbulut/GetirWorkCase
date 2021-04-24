package com.GetirProject.pages;

import com.GetirProject.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class RestoranPage extends Dashboard{

    @FindBy(xpath = "//p[@contenteditable='false']")
    public WebElement firstProduct;

    @FindBy(xpath = "//button[contains(.,'Sepete Ekle')]")
    public WebElement sepeteEkleButton;

    @FindBy(xpath = "//button[contains(.,'Sepete git')]")
    public WebElement sepeteGitButton;

    @FindBy(xpath = "(//*[@class='style__Products-bj8eho-0 kiNHRJ']//span)[1]")
    public WebElement sepettekiUrunler;

    @FindBy(xpath = "(//*[@name='delete-1'])[1]")
    public WebElement deleteFromSepet;

    @FindBy(css = ".style__Wrapper-sc-6ivys6-1.haSjLq.style__OkButton-vk2nyz-8.gnGJVu")
    public WebElement deleteEvetBttn;



    public boolean compareTheProduct(String prodText){
        BrowserUtils.waitFor(2);
            if(sepettekiUrunler.getText().toLowerCase().contains(prodText.toLowerCase())) {
                return true;
            }else return false;
    }




}
