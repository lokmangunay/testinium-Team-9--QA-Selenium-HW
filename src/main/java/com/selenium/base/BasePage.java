package com.selenium.base;

import com.selenium.page.ProductDetailPage;
import com.selenium.page.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    public Map<String, String> storeVariable = new HashMap<>();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public WebElement find(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public List<WebElement> findAll(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

    }

    public void click(By locator) {
        WebElement element = find(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void type(By locator, CharSequence text) {
        WebElement element = find(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void scrollDown() {
        JavascriptExecutor Js1 = (JavascriptExecutor) driver;
        Js1.executeScript("window.scrollBy(0,500)");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public ProductDetailPage getProductDetailPage() {
        return new ProductDetailPage(driver);
    }

    public ProductsPage getProductsPage() {
        return new ProductsPage(driver);
    }
}
