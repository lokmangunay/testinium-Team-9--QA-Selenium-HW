package com.selenium.page;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritesProductsPage extends BasePage {

    public FavoritesProductsPage(WebDriver driver) {
        super(driver);
    }

    By addToCartButton = By.xpath("//div[@class='basket-button   ']");

    /*  public void selectSize(String size){
        Select objSelect =new Select(driver.findElement(By.xpath("//select[@class='size-dropdown cursor ']")));
        objSelect.selectByVisibleText(size);
    }   */
    public void addToCartMethod() {
        click(addToCartButton);
    }


}
