package fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemContainerHelper extends BaseHelper {
    
    public static final String PRODUCTS_CONTAINER_PAGE_XPATH = "//android.view.ViewGroup[@content-desc='products screen']/android.widget.ScrollView";
    public static final String ADD_TO_CART_BTN_XPATH = "//android.view.ViewGroup[@content-desc='Add To Cart button']";
    public static final String ITEM_CARD_XPATH = "(//android.view.ViewGroup[@content-desc='store item'])[$idx]//android.widget.ImageView";
    public static final String ITEM_COUNTER_PLUS_BTN_XPATH = "//android.view.ViewGroup[@content-desc='counter plus button']/android.widget.ImageView";
    public static final String COLOUR_OPTION_ITEM_XPATH = "//android.view.ViewGroup[@content-desc='[$colour] circle']/android.view.ViewGroup";
    public static final String RED_COLOUR_OPTION_ITEM_XPATH = "//android.view.ViewGroup[@content-desc='red circle']/android.view.ViewGroup";
    public static final String GRAY_COLOUR_OPTION_ITEM_XPATH = "//android.view.ViewGroup[@content-desc='gray circle']/android.view.ViewGroup";
    public static final String OPEN_MENU_BTN_XPATH = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView";
    public static final String CATALOG_BTN_XPATH = "//android.view.ViewGroup[@content-desc='open menu']";


    public ItemContainerHelper(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForItemContainerPageToLoad() {
        return waitForElementToLoad(By.xpath(PRODUCTS_CONTAINER_PAGE_XPATH));
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


    public void addSauceLabsOnesieDefaultColourToShoppingCart() {
        swipeToStoreItem("store item", "Sauce Labs Onesie");
        clickOnItemCard(5);
        addItemToShoppingCart();

    }
    public void addItemToShoppingCart() {
        waitUntilElementIsClickable(By.xpath(ADD_TO_CART_BTN_XPATH));
        tap(By.xpath(ADD_TO_CART_BTN_XPATH));
        waitUntilElementIsClickable(By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView"));


    }

    public void clickItemQuantityPlusButton() {
        tap(By.xpath(ITEM_COUNTER_PLUS_BTN_XPATH));
    }

    public void swipeToStoreItem(String scrollableList, String itemTitle ) {
        try {
            String elementClassName = "android.widget.TextView";

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().description(\"" + scrollableList + "\")).getChildByText("
                            + "new UiSelector().className(\"" + elementClassName + "\"), \"" + itemTitle + "\")"));
        } catch (Exception e) {
            System.out.println("Cannot scroll further");
        }
    }


//    public void chooseColourOfItem(Colour colour) {
//        waitUntilElementIsClickable(By.xpath(COLOUR_OPTION_ITEM_XPATH.replace("$colour", colour.toString())));
//        tap(By.xpath(COLOUR_OPTION_ITEM_XPATH.replace("$colour", colour.toString())));
//    }

    public void chooseRedColourOfItem(){
        waitUntilElementIsClickable(By.xpath(RED_COLOUR_OPTION_ITEM_XPATH));
        tap(By.xpath(RED_COLOUR_OPTION_ITEM_XPATH));
    }

    public void chooseGrayColourOfItem(){
        waitUntilElementIsClickable(By.xpath(GRAY_COLOUR_OPTION_ITEM_XPATH));
        tap(By.xpath(GRAY_COLOUR_OPTION_ITEM_XPATH));
    }


    public void returnToItemContainerPage() {
        openMenu();
        waitUntilElementIsClickable(By.xpath(CATALOG_BTN_XPATH));
        tap(By.xpath(CATALOG_BTN_XPATH));
        waitForItemContainerPageToLoad();
    }

    public void addSauceLabsBackpackDefaultColourToShoppingCart() {
        swipeToStoreItem("store item", "Sauce Labs Backpack");
        clickOnItemCard(1);
        addItemToShoppingCart();
    }

    public WebElement waitForAddToCartBtnToLoad() {
        return waitForElementToLoad(By.xpath(ADD_TO_CART_BTN_XPATH));
    }
}




