package com.GetirProject.pages;

import com.GetirProject.utilities.BrowserUtils;
import com.GetirProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyPage extends Dashboard{

    @FindBy(xpath = "//input[@placeholder='Yemek veya restoran ara']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@data-testid='dropdown-title']")
    public WebElement profil;

    @FindBy(xpath = "//h1[@data-testid='title']")
    public List<WebElement> allResultLinks;

    @FindBy(xpath = "//figure[@class='style__ImageWrapper-sc-1h9bp23-1 lcRint style__Image-sc-1yxj8ro-2 iZMWCZ']/img")
    public WebElement firstRestrount;


    /**
     * this method gives you the element of Profil dropdown list based on the UI names
     *
     * @param menu
     *
     * @return WebElement
     */
    public WebElement profilMenu(String menu){
        return Driver.get().findElement(By.xpath("//a[contains(.,'"+menu+"')]"));
    }



    /**
     * this method gives you all the products form drop down list, when you search a word in search button.
     *      it collcts the product names one by one and add them in to a list.
     *
     * @param
     *
     * @return List
     */
    public List<String> createProductListSearched(){
        String product="";
        List<String> list=new ArrayList<>();
        for(int i=1; i<allResultLinks.size(); i++){
            String path="(//h1[@data-testid='title'])["+i+"]/span";
            List<WebElement> elements=Driver.get().findElements(By.xpath(path));
            for(WebElement elm:elements){
                product+=elm.getText();
            }
            list.add(product);
            product="";
        }
        return list;
    }



    /**
     * this method checks all the product coming from search dropdown if it included the searching word or not.
     *      to do this, it use the list coming from above method.
     *
     * @param searchItem
     *
     * @return boolean
     */
    public boolean checkTheResults(String searchItem){
        BrowserUtils.waitFor(5);
        for (String product: createProductListSearched()){
           if( !product.toLowerCase().contains(searchItem.toLowerCase()))
               return false;
        }
        return true;
    }










}
