package fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {

    AppiumDriver driver;
    DesiredCapabilities capabilities;

    LoginHelper loginHelper;
    HeaderHelper headerHelper;
    MenuHelper menuHelper;

    ShoppingCartHelper shoppingCartHelper;

    ItemContainerHelper itemContainerHelper;
    ProductsContainerHelper productsContainerHelper;

    public ProductsContainerHelper getProductsContainerHelper() {
        return productsContainerHelper;
    }

    public HeaderHelper getHeaderHelper() {
        return headerHelper;
    }

    public MenuHelper getMenuHelper() {
        return menuHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }


    public ItemContainerHelper getItemContainerHelper() {
        return itemContainerHelper;
    }

    public ShoppingCartHelper getShoppingCartHelper() {
        return shoppingCartHelper;
    }


    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "Pixel_5_mobile_testing");
        capabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        capabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        capabilities.setCapability("app", "/Users/anastasiiahontsova/Desktop/TelRan/QA_lessons/QA_PRO/Android/Demo244.apk");

        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        loginHelper = new LoginHelper(driver);
        menuHelper = new MenuHelper(driver);
        headerHelper = new HeaderHelper(driver);
        productsContainerHelper = new ProductsContainerHelper(driver);
        itemContainerHelper = new ItemContainerHelper(driver);
        shoppingCartHelper = new ShoppingCartHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public void openDeepLink(String path) {
        driver.get("mydemoapprn://" + path);
    }
}