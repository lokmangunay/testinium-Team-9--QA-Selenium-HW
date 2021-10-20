package com.selenium.page;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public By productNameLocatorOnCartPage= By.xpath("//p[@class='pb-item']");
    public By productRemoveFromTheCartButton=By.cssSelector("i[class='i-trash']");

   public String getProductNameOnCartPage(){
       return find(productNameLocatorOnCartPage).getText();

   }
   public void productRemoveFromTheCartMethod(){
       click(productRemoveFromTheCartButton);
   }
}
