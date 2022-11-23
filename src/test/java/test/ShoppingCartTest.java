package test;

import fw.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {

    public static final String PRODUCTS_CONTAINER_PAGE_XPATH = "//android.view.ViewGroup[@content-desc='products screen']/android.widget.ScrollView";
    public static final String ADD_TO_CART_BTN_XPATH = "//android.view.ViewGroup[@content-desc='Add To Cart button']";

    @Test
    public void addItemToShoppingCartBaseTest() {
        app.getItemContainerHelper().waitToLoad(By.xpath(PRODUCTS_CONTAINER_PAGE_XPATH));
        app.getItemContainerHelper().clickOnItemCard(1);
        app.getItemContainerHelper().waitToLoad(By.xpath(ADD_TO_CART_BTN_XPATH));
        app.getItemContainerHelper().addItemToShoppingCart();
        app.getHeaderHelper().waitForShoppingCartCounterToShowAddedItems();
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(), "1", "Items number badge on the shopping cart icon shows: 1.");
    }
}


