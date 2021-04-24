package com.GetirProject.pages;

import com.GetirProject.utilities.BrowserUtils;
import com.GetirProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class Adreslerim extends Dashboard{



    @FindBy(css = ".style__Input-sc-1wqqe47-4.cVnmQW.react-autosuggest__input")
    public WebElement findAddress;

    @FindBy(xpath = "//button[contains(.,'Bu adresi kullan')]")
    public WebElement buAdresiKullanButton;

    @FindBy(xpath = "//button[contains(.,'Kaydet')]")
    public WebElement adresKaydetButton;

    @FindBy(xpath = "//button[contains(.,'Evet')]")
    public WebElement evetButton;

    @FindBy(css = ".style__Text-sc-1nwjacj-0.dpookf.style__Text-o6db8r-1.style__AddressDescription-o6db8r-10.jQWwGW")
    public List<WebElement> addresses;





    /**
     * this method gives you the element of "Ev adresi, İş adresi, Diğer adres" from Adreslerim page
     *
     * @param addressType
     *
     * @return WebElement
     */
    public WebElement chooseAddress(String addressType){
        return Driver.get().
                findElement(By.xpath("(//*[contains(@class,'style__Wrapper-sc')][contains(.,'"+addressType+"')])[3]"));
    }

    /**
     * this method gives you the element of inputs accroding to placeholder from Adreslerim page
     *
     * @param address
     *
     * @return WebElement
     */
    public WebElement inputAddressType(String address){
        return Driver.get().findElement(By.xpath("//*[@placeholder='"+address+"']"));
    }


    /**
     * this method create an address beyond your willing address type. Map comes from feature files
     *          scenario outline and then step definitions then to this method.
     *
     * @param address
     *
     * @return
     */

    public void createAddress(Map<String,Object> address){
        BrowserUtils.waitFor(1);
        inputAddressType("Örn. Etiler mh.")
                .sendKeys("Palandöken", Keys.ARROW_DOWN);

        Driver.get().findElement(By.cssSelector("#react-autowhatever-1--item-0")).click();

        BrowserUtils.clickWithTimeOut(buAdresiKullanButton, 10);

        for(String key: address.keySet()){
           inputAddressType(key).sendKeys(String.valueOf(address.get(key)));
        }

        adresKaydetButton.click();
        evetButton.click();
        BrowserUtils.waitFor(10);

    }


    /**
     * this method verify your creating address if it correctly created or not.
     *
     * @param adres
     *
     * @return boolean
     */

    public boolean confirmAddress(String adres){
        List<String> addresses = BrowserUtils.getElementsText(this.addresses);
        for(String address:addresses){
            if((address.toLowerCase()).contains(adres.toLowerCase())){
                return true;
            }
        }
        return false;
    }

}
