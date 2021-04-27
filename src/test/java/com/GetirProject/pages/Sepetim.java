package com.GetirProject.pages;

import com.GetirProject.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sepetim extends Dashboard{
    @FindBy(xpath = "(//*[@class='style__Products-bj8eho-0 kiNHRJ']//span)[1]")
    public WebElement sepettekiUrunler;

    @FindBy(xpath = "(//*[@name='delete-1'])[1]")
    public WebElement deleteFromSepet;

    @FindBy(css = ".style__Wrapper-sc-6ivys6-1.haSjLq.style__OkButton-vk2nyz-8.gnGJVu")
    public WebElement deleteEvetBttn;


    /**
     * this method is compaiting the product's title with parameter. parameter comes from step definitions
     *      class. before vm cliks the product, it takes it's name as instance variable then it uses this
     *      variable int this method as a parameter.
     *
     * @param prodText
     *
     * @return boolean
     */
    public boolean compareTheProduct(String prodText){
        BrowserUtils.waitFor(2);
        if(sepettekiUrunler.getText().toLowerCase().contains(prodText.toLowerCase())) {
            return true;
        }else return false;
    }
}
