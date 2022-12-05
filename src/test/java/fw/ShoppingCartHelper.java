package fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ShoppingCartHelper extends BaseHelper {

    //public static final String NAME_OF_ADDED_ITEM_IN_SHOPPING_CART_XPATH = "(//android.view.ViewGroup[@content-desc='product row'])[$index]/android.widget.ImageView";

    public static final String NAME_OF_FIRST_ADDED_ITEM_IN_SHOPPING_CART_XPATH = "(//android.widget.TextView[@content-desc='product label'])[1]";
    public static final String NAME_OF_SECOND_ADDED_ITEM_IN_SHOPPING_CART_XPATH = "(//android.widget.TextView[@content-desc='product label'])[2]";
    public static final String NAME_OF_THIRD_ADDED_ITEM_IN_SHOPPING_CART_XPATH = "(//android.view.ViewGroup[@content-desc='product row'])[3]/android.widget.ImageView";

    public static final String FORTH_ADDED_ITEM_IN_SHOPPING_CART_XPATH = "(//android.widget.TextView[@content-desc='product label'])[4]";
    public static final String PRICE_OF_FIRST_ITEM_IN_SHOPPING_CART_XPATH = "(//android.widget.TextView[@content-desc='product price'])[1]";

    public static final String PRICE_OF_SECOND_ITEM_IN_SHOPPING_CART_XPATH = "(//android.widget.TextView[@content-desc='product price'])[2]";

    public static final String PRICE_OF_THIRD_ITEM_IN_SHOPPING_CART_XPATH = "(//android.widget.TextView[@content-desc='product price'])[3]";

    public static final String PRICE_OF_FORTH_ITEM_IN_SHOPPING_CART_XPATH = "(//android.widget.TextView[@content-desc='product price'])[4]";
    public static final String QUANTITY_OF_FIRST_ITEM_IN_SHOPPING_CART_XPATH = "(//android.view.ViewGroup[@content-desc='counter amount'])[1]/android.widget.TextView";
    public static final String QUANTITY_OF_SECOND_ITEM_IN_SHOPPING_CART_XPATH = "(//android.view.ViewGroup[@content-desc='counter amount'])[2]/android.widget.TextView";
    public static final String QUANTITY_OF_THIRD_ITEM_IN_SHOPPING_CART_XPATH = "(//android.view.ViewGroup[@content-desc='counter amount'])[3]/android.widget.TextView";
    public static final String QUANTITY_OF_FORTH_ITEM_IN_SHOPPING_CART_XPATH = "(//android.view.ViewGroup[@content-desc='counter amount'])[4]/android.widget.TextView";
    public static final String SHOPPING_CART_SCREEN = "//android.widget.ScrollView[@content-desc='cart screen']/android.view.ViewGroup";

    public static final String EMPTY_SHOPPING_CART_BADGE = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView";

    public ShoppingCartHelper(AppiumDriver driver) {
        super(driver);
    }

    public String getAddedItemCounterNumber(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getNameOfFirstAddedItem() {
        waitUntilElementIsPresent(By.xpath(NAME_OF_FIRST_ADDED_ITEM_IN_SHOPPING_CART_XPATH));
        return driver.findElement(By.xpath(NAME_OF_FIRST_ADDED_ITEM_IN_SHOPPING_CART_XPATH)).getText();
    }

    public String getNameOfSecondAddedItem() {
        waitUntilElementIsPresent(By.xpath(NAME_OF_SECOND_ADDED_ITEM_IN_SHOPPING_CART_XPATH));
        return driver.findElement(By.xpath(NAME_OF_SECOND_ADDED_ITEM_IN_SHOPPING_CART_XPATH)).getText();
    }


    public String getNameOfThirdAddedItem() {
        swipeToItemInShoppingCart("product label", "[2]");
        waitUntilElementIsPresent(By.xpath(NAME_OF_THIRD_ADDED_ITEM_IN_SHOPPING_CART_XPATH));
        return driver.findElement(By.xpath(NAME_OF_THIRD_ADDED_ITEM_IN_SHOPPING_CART_XPATH)).getText();

    }
//
//    public String getNameOfForthAddedItem() {
//        return driver.findElement(By.xpath(FORTH_ADDED_ITEM_IN_SHOPPING_CART_XPATH)).getText();
//
//    }

    public String getPriceOfFirstAddedItem() {
        return driver.findElement(By.xpath(PRICE_OF_FIRST_ITEM_IN_SHOPPING_CART_XPATH)).getText();
    }

    public String getPriceOfSecondAddedItem() {
        return driver.findElement(By.xpath(PRICE_OF_SECOND_ITEM_IN_SHOPPING_CART_XPATH)).getText();
    }

    public String getPriceOfThirdAddedItem() {
        return driver.findElement(By.xpath(PRICE_OF_THIRD_ITEM_IN_SHOPPING_CART_XPATH)).getText();
    }
//
//    public String getPriceOfForthAddedItem() {
//        return driver.findElement(By.xpath(PRICE_OF_FORTH_ITEM_IN_SHOPPING_CART_XPATH)).getText();
//    }


    public String getColourOfFirstAddedItem() {
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='red circle']/android.view.ViewGroup")).getText();
    }

    public String getQuantityOfFirstAddedItem() {
        return driver.findElement(By.xpath(QUANTITY_OF_FIRST_ITEM_IN_SHOPPING_CART_XPATH)).getText();
    }

    public String getQuantityOfSecondAddedItem() {
        return driver.findElement(By.xpath(QUANTITY_OF_SECOND_ITEM_IN_SHOPPING_CART_XPATH)).getText();

    }

    public String getQuantityOfThirdAddedItem() {
        return driver.findElement(By.xpath(QUANTITY_OF_THIRD_ITEM_IN_SHOPPING_CART_XPATH)).getText();

    }

//    public String getQuantityOfForthAddedItem() {
//        return driver.findElement(By.xpath()).getText();
//
//    }

    public boolean verifyShoppingCartIsEmpty() {
        waitUntilElementIsClickable(By.xpath(SHOPPING_CART_BTN_XPATH));
        goToShoppingCart();
        waitUntilElementIsPresent(By.xpath(SHOPPING_CART_SCREEN));
        if (driver.findElement(By.xpath(EMPTY_SHOPPING_CART_BADGE)).getText() != null) ;
        return true;
    }

    public void swipeToItemInShoppingCart(String scrollableList, String itemTitle) {
        try {
            String elementClassName = "android.widget.TextView";

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().description(\"" + scrollableList + "\")).getChildByText("
                            + "new UiSelector().className(\"" + elementClassName + "\"), \"" + itemTitle + "\")"));
        } catch (Exception e) {
            System.out.println("Cannot scroll further");
        }
    }





}
