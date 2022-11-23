package fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemContainerHelper extends BaseHelper {

    public static final String ITEM_CARD_XPATH = "(//android.view.ViewGroup[@content-desc='store item'])[$idx]//android.widget.ImageView";
    public static final String ADD_TO_CART_BTN_XPATH = "//android.view.ViewGroup[@content-desc='Add To Cart button']";


    public ItemContainerHelper(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitToLoad(By locator) {
        return waitForElementToLoad(locator);
    }

    public boolean isItemContainer(By locator) {
        return isElementPresent(locator);
    }


    //public void clickOnItemCard!(By locator) {
//        waitUntilElementIsClickable(locator);
//        tap(locator);

        public void clickOnItemCard(Integer idx) {
            waitUntilElementIsClickable(By.xpath(ITEM_CARD_XPATH.replace("$idx", idx.toString())));
            tap(By.xpath(ITEM_CARD_XPATH.replace("$idx", idx.toString())));
        }


    public void addItemToShoppingCart() {
        swipeDown();
        waitUntilElementIsClickable(By.xpath(ADD_TO_CART_BTN_XPATH));
        tap(By.xpath(ADD_TO_CART_BTN_XPATH));

    }


}


