package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderHelper extends BaseHelper {
    private static final String MENU_BTN_XPATH = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView";
    public static final String ADDED_ITEMS_CART_BADGE_XPATH = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView";





    public HeaderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnMenuBtn() {
        tap(By.xpath(MENU_BTN_XPATH));
    }

    public void waitForMenuBtnToLoad() {
        waitUntilElementIsClickable(By.xpath(MENU_BTN_XPATH));
    }

    public void waitForShoppingCartCounterToShowAddedItems() {
        waitUntilElementIsPresent(By.xpath(ADDED_ITEMS_CART_BADGE_XPATH));
    }

    public String getAddedItemsCounterNumber() {
        waitForShoppingCartCounterToShowAddedItems();
        return driver.findElement(By.xpath(ADDED_ITEMS_CART_BADGE_XPATH)).getText();
    }




}