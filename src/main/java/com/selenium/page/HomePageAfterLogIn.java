package com.selenium.page;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePageAfterLogIn extends BasePage {

    public HomePageAfterLogIn(WebDriver driver) {
        super(driver);
    }


    public void searchAProductMethod(String product) {
        click(By.className("search-box"));
        type(By.className("search-box"), product + Keys.ENTER);
    }


}
