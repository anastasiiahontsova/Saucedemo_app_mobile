package test;

import fw.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ShoppingCartTest extends TestBase {

    public static final String PRODUCTS_CONTAINER_PAGE_XPATH = "//android.view.ViewGroup[@content-desc='products screen']/android.widget.ScrollView";
    public static final String ADD_TO_CART_BTN_XPATH = "//android.view.ViewGroup[@content-desc='Add To Cart button']";
    public static final String BLUE_COLOUR_ITEM_XPATH = "//android.view.ViewGroup[@content-desc='blue circle']/android.view.ViewGroup";
    public static final String RED_COLOUR_ITEM_XPATH = "//android.view.ViewGroup[@content-desc='red circle']/android.view.ViewGroup";
    public static final String ADDED_ITEMS_CART_BADGE_XPATH = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView";

    @Test
    public void addItemToShoppingCartBaseTest() {
        app.getItemContainerHelper().waitToLoad(By.xpath(PRODUCTS_CONTAINER_PAGE_XPATH));
        app.getItemContainerHelper().clickOnItemCard(1);
        app.getItemContainerHelper().waitToLoad(By.xpath(ADD_TO_CART_BTN_XPATH));
        app.getItemContainerHelper().addItemToShoppingCart();
        app.getHeaderHelper().waitForShoppingCartCounterToShowAddedItems();
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(By.xpath(ADDED_ITEMS_CART_BADGE_XPATH)), "1", "Items number badge on the shopping cart icon shows: 1.");
    }

    @Test
    public void addSameItemOfDifferentColoursAndQuantityToShoppingCartTest() {
        app.getItemContainerHelper().waitToLoad(By.xpath(PRODUCTS_CONTAINER_PAGE_XPATH));
        app.getItemContainerHelper().clickOnItemCard(1);
        app.getItemContainerHelper().waitToLoad(By.xpath(ADD_TO_CART_BTN_XPATH));
        app.getItemContainerHelper().addItemToShoppingCart();
        app.getItemContainerHelper().selectItemColour(By.xpath(BLUE_COLOUR_ITEM_XPATH));
        app.getItemContainerHelper().addItemToShoppingCart();
        app.getItemContainerHelper().selectItemColour(By.xpath(RED_COLOUR_ITEM_XPATH));
        app.getItemContainerHelper().clickItemQuantityPlusButton();
        app.getItemContainerHelper().addItemToShoppingCart();
        app.getHeaderHelper().waitForShoppingCartCounterToShowAddedItems();
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(By.xpath(ADDED_ITEMS_CART_BADGE_XPATH)), "4", "Items number badge on the shopping cart icon shows: 4.");

        //app.getShoppingCartHelper().goToShoppingCart();
        //assert item number for black backpack is 1, assert the color is black
        //Assert.assertEquals(app.getShoppingCartHelper().getAddedItemsCounterNumber(By.xpath("(//android.view.ViewGroup[@content-desc='product row'])[1]")), 1,  "Black");
        //assert item number for blue backpack is 1, assert the color is blue
        //Assert.assertEquals(app.getShoppingCartHelper().getAddedItemsCounterNumber(), 1, "Blue");
        //srcrollDown()
        //assert item number for red backpack is 2, assert the color is red
        //Assert.assertEquals(app.getShoppingCartHelper().getAddedItemsCounterNumber(), 2, "Red");
        //srcrollDown()
        //assert the price for 4 backpacks is $89.97


    }
}


