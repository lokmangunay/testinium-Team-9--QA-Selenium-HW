package com.selenium.test;

import com.selenium.base.TestMethods;
import com.selenium.page.ProductDetailPage;
import org.junit.*;

public class TestingTrendyol extends TestMethods {

    ProductDetailPage productDetailPage;

    @Before
    public void before() {
        productDetailPage = new ProductDetailPage(driver);
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        selectGender("female");
        goToLogInPage();
        logIn();
        searchAProduct("kazak");
        selectAProduct(10);
        switchToNextTab();
        productDetailPage
                .addToFavMethod().
                addToCartMethod()
                .goToCartMethod();

        isProductAddedToCart();
    }


    @After
  public void tearDown(){
        terminateTheTest();
  }
}
