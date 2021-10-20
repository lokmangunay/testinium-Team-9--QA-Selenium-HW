package com.selenium.page;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAll() {
        By productNameLocator = By.className("prdct-desc-cntnr");
        return findAll(productNameLocator);
    }


    public void selectAProductMethod(int nThProduct) {
        getAll().get(nThProduct - 1).click();
    }

    public String getProductName(int nthProduct) {
        return getAll().get(nthProduct - 1).getText();
    }

    public void saveProductName(int nthProduct) {
        storeVariable.put("productName", getProductName(nthProduct));
    }


}
