package fw;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BaseHelper {
    public static final int EXPL_WAIT_SEC = 10;
    public static final String SHOPPING_CART_BTN_XPATH = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView";
    AppiumDriver driver;

    public BaseHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilElementIsClickable(By locator) {
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, EXPL_WAIT_SEC);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void sleep(int seconds) {
        //implicit wait
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public WebElement waitForElementToLoad(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPL_WAIT_SEC);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void typeAndTapEnter(By locator, String text) {
        type(locator, text);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public WebElement waitUntilElementIsPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPL_WAIT_SEC);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getTextOfTheElement(By locator) {
        return driver.findElement(locator).getText();
    }

    public void swipeDown() {
        try {
            String scrollableList = "product screen";
            String elementClassName = "android.widget.TextView";
            String anyText = "Add To Cart button";

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().description(\"" + scrollableList + "\")).getChildByText("
                            + "new UiSelector().className(\"" + elementClassName + "\"), \"" + anyText + "\")"));
        } catch (Exception e) {
            System.out.println("Cannot scroll further");
        }
    }

    public void goToShoppingCart() {
        tap(By.xpath(SHOPPING_CART_BTN_XPATH));
    }
}