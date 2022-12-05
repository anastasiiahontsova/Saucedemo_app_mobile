package test;

import fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ShoppingCartTest extends TestBase {

    @Test
    public void addItemToShoppingCartBaseTest() {
        app.getItemContainerHelper().waitForItemContainerPageToLoad();
        app.getItemContainerHelper().clickOnItemCard(1);
        app.getItemContainerHelper().waitForAddToCartBtnToLoad();
        app.getItemContainerHelper().addItemToShoppingCart();
        app.getHeaderHelper().waitForShoppingCartCounterToShowAddedItems();
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(), "1", "Number of items on the shopping cart icon shows: 1.");
    }

    @Test
    public void addMultipleItemsToToShoppingCartTest() {
        app.getItemContainerHelper().waitForItemContainerPageToLoad();
        app.getItemContainerHelper().addSauceLabsOnesieDefaultColourToShoppingCart();
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(), "1", "Number of items on the shopping cart icon shows: 1.");
        app.getItemContainerHelper().chooseGrayColourOfItem();
        app.getItemContainerHelper().clickItemQuantityPlusButton();
        app.getItemContainerHelper().addItemToShoppingCart();
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(), "3", "Number of items on the shopping cart icon shows: 3.");
        app.getItemContainerHelper().returnToItemContainerPage();
        app.getItemContainerHelper().addSauceLabsBackpackDefaultColourToShoppingCart();
        app.getItemContainerHelper().chooseRedColourOfItem();
        app.getItemContainerHelper().clickItemQuantityPlusButton();
        app.getItemContainerHelper().clickItemQuantityPlusButton();
        app.getItemContainerHelper().addItemToShoppingCart();
        Assert.assertEquals(app.getHeaderHelper().getAddedItemsCounterNumber(), "7", "Number of items on the shopping cart icon shows: 7.");

        app.getShoppingCartHelper().goToShoppingCart();
        Assert.assertEquals(app.getShoppingCartHelper().getNameOfFirstAddedItem(), "Sauce Labs Onesie", "The name of the added item in shopping cart is : Sauce Labs Onesie.");
        Assert.assertEquals(app.getShoppingCartHelper().getPriceOfFirstAddedItem(), "$7.99", "The price of the added item in shopping cart is : $7.99.");
        //Assert.assertEquals(app.getShoppingCartHelper().getColourOfFirstAddedItem(), "red", "The colour of the added item in shopping cart is : red.");
        Assert.assertEquals(app.getShoppingCartHelper().getQuantityOfFirstAddedItem(), "1", "The quantity of the added item in shopping cart is : 1.");

        Assert.assertEquals(app.getShoppingCartHelper().getNameOfSecondAddedItem(), "Sauce Labs Onesie", "The name of the added item in shopping cart is : Sauce Labs Onesie.");
        Assert.assertEquals(app.getShoppingCartHelper().getPriceOfSecondAddedItem(), "$7.99", "The price of the added item in shopping cart is : $7.99.");
//      Assert.assertEquals(app.getShoppingCartHelper().getColourOfSecondAddedItem(), "gray", "The colour of the added item in shopping cart is : gray.");
        Assert.assertEquals(app.getShoppingCartHelper().getQuantityOfSecondAddedItem(), "2", "The quantity of the added item in shopping cart is : 2.");

        Assert.assertEquals(app.getShoppingCartHelper().getNameOfThirdAddedItem(), "Sauce Labs Backpack", "The name of the added item in shopping cart is : Sauce Labs Backpack.");
        //Assert.assertEquals(app.getShoppingCartHelper().getPriceOfThirdAddedItem(), "$29.99", "The price of the added item in shopping cart is : $29.99.");
          //Assert.assertEquals(app.getShoppingCartHelper().getColourOfThirdAddedItem(), "black", "The colour of the added item in shopping cart is : black.");
        //Assert.assertEquals(app.getShoppingCartHelper().getQuantityOfThirdAddedItem(), "1", "The quantity of the added item in shopping cart is : 1.");

        //Assert.assertEquals(app.getShoppingCartHelper().getNameOfForthAddedItem(), "Sauce Labs Backpack", "The name of the added item in shopping cart is : Sauce Labs Backpack.");
//        Assert.assertEquals(app.getShoppingCartHelper().getPriceOfForthAddedItem(), "$29.99", "The price of the added item in shopping cart is : $29.99.");
        //Assert.assertEquals(app.getShoppingCartHelper().getColourOfForthAddedItem(), "red", "The colour of the added item in shopping cart is : red.");
//        Assert.assertEquals(app.getShoppingCartHelper().getQuantityOfForthAddedItem(), "3", "The quantity of the added item in shopping cart is : 3.");

//      check total price in shopping cart


        app.getMenuHelper().resetAppState();
        Assert.assertTrue(app.getShoppingCartHelper().verifyShoppingCartIsEmpty(), "Number of items on the shopping cart icon shows: 0.");


        //Add item(s) to the cart, close the browser and reopen the same site.
        //
    }
}


