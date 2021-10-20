package com.selenium.page;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ProductDetailPage extends BasePage {
    final static Logger logger = Logger.getLogger(String.valueOf(ProductDetailPage.class));

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    By addToFavButton = By.xpath("//button[@class='fv']");
    By goToFavButton = By.xpath("//div[@class='link']");
    By addToCartButton = By.xpath("//button[@class='add-to-basket']");
    By goToCartButton = By.cssSelector("a[class='link account-basket']");

    public ProductDetailPage addToFavMethod() throws InterruptedException {
        click(addToFavButton);
        TimeUnit.SECONDS.sleep(2);
        logger.info("ürün favorilere eklendi");
        return this;
    }

    public ProductDetailPage goToFavMethod() {
        click(goToFavButton);
        return this;
    }

    public ProductDetailPage addToCartMethod() {
        click(addToCartButton);
        return this;
    }

    public ProductDetailPage goToCartMethod() {
        click(goToCartButton);
        return this;
    }
}
