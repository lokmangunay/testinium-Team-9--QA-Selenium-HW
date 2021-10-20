package com.selenium.page;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageBeforeLogIn extends BasePage {

    public HomePageBeforeLogIn(WebDriver driver) {
        super(driver);
    }


    public void selectGender(String gender) {
        By genderSelectorLocator;
        if (gender == "female") {
            genderSelectorLocator = By.xpath("//*[@class='homepage-popup-img']");  // female gender

        } else if (gender == "male") {
            genderSelectorLocator = By.xpath("//*[@class='homepage-popup-img']");  // male gender --> bunu düzelt

        } else {
            genderSelectorLocator = By.id("Rating-Review");

        }
        click(genderSelectorLocator);


    }

    public void goTologInPage() {


        WebElement logInButtonHomePage = driver.findElement(By.xpath("//p[text()='Giriş Yap']"));

        logInButtonHomePage.click();
    }


}
