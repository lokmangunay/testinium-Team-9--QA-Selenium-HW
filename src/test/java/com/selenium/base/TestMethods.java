package com.selenium.base;

import com.selenium.page.*;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestMethods {

    final static Logger logger = Logger.getLogger(String.valueOf(TestMethods.class));

    protected WebDriver driver;
    ChromeOptions options;
    HomePageBeforeLogIn homePageBeforeLogIn;
    LoginPage loginPage;
    HomePageAfterLogIn homePageAfterLogIn;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    FavoritesProductsPage favoritesProductsPage;
    CartPage cartPage;
    public String selectedProductName = " ";
    public String productNameInCart = "";


    @Before
    public void setUp() {
        logger.info("Test başlatıldı.");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        this.driver = new ChromeDriver(options);
        homePageBeforeLogIn = new HomePageBeforeLogIn(driver);
        driver.get("https://www.trendyol.com");
        logger.info("Yönlendirilen sayfa : " + driver.getTitle());

    }

    public void terminateTheTest() {
        driver.quit();
    }

    public void selectGender(String gender) {
        homePageBeforeLogIn.selectGender(gender);
        if (gender.equals("male")) {
            logger.info("Erkek Kategorisi Seçildi.");
        } else if (gender.equals("female")) {
            logger.info("Kadın Kategorisi seçildi");
        } else {
            logger.info("Herhangi bir kategori seçilmedi");
        }
        logger.info("Yönlendirilen sayfa : " + driver.getTitle());

    }

    public void goToLogInPage() {
        homePageBeforeLogIn.goTologInPage();
        logger.info("Yönlendirilen sayfa : " + driver.getTitle());

        loginPage = new LoginPage(driver);
    }

    public void logIn() throws InterruptedException {
        loginPage.logInMethod("fake@gmail.com", "fakepass");
        // password is hidden for security reasons. Use your own credentials while running the test.
        logger.info("Giriş Yaptınız. Yöndendirilen Sayfa: " + driver.getTitle());
        homePageAfterLogIn = new HomePageAfterLogIn(driver);
        TimeUnit.SECONDS.sleep(3);


    }

    public void searchAProduct(String productToBeSearched) throws InterruptedException {
        homePageAfterLogIn.searchAProductMethod(productToBeSearched);
        productsPage = new ProductsPage(driver);
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(2);
    }

    public void selectAProduct(int nthProduct) {
        productsPage.selectAProductMethod(nthProduct);
        productDetailPage = new ProductDetailPage(driver);
        selectedProductName = productsPage.getProductName(nthProduct);
        logger.info(nthProduct +
                ". Ürün seçildi. Seçilen Ürün: " + selectedProductName);
    }

    public void goToFav() {
        productDetailPage.goToFavMethod();
        logger.info("Yönlendirilen sayfa: Favorilerim ");
        favoritesProductsPage = new FavoritesProductsPage(driver);
    }

    public void addToCart() throws InterruptedException {
        productDetailPage.addToCartMethod();
        TimeUnit.SECONDS.sleep(2);


    }

    public void goToCart() {
        productDetailPage.goToCartMethod();
        cartPage = new CartPage(driver);
        productNameInCart = cartPage.getProductNameOnCartPage();
        logger.info("Sepetteki Ürün: " + productNameInCart);

    }

    public void isProductAddedToCart() {
        Assert.assertEquals("Sepetteki ürün istenilen ürün değil", selectedProductName, productNameInCart);
    }

    public void switchToNextTab() {
        String parent = driver.getWindowHandle();

        Set<String> s = driver.getWindowHandles();

        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    }

    public void emptyTheCart() {
        cartPage.productRemoveFromTheCartMethod();

    }
}
