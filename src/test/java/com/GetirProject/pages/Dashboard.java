package com.GetirProject.pages;

import com.GetirProject.utilities.Driver;
import org.openqa.selenium.By;

public class Dashboard extends BasePage {

    @Override
    public String getTitle() {

        return Driver.get().getTitle();
    }

    @Override
    public String getHeader() {
        return Driver.get().findElement(By.tagName("header")).getText();
    }
}
