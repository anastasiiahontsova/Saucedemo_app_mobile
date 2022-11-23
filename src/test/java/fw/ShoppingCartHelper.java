package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import javax.swing.text.html.HTMLDocument;

public class ShoppingCartHelper extends BaseHelper{

    public ShoppingCartHelper(AppiumDriver driver) {
        super(driver);
    }

    public String  getAddedItemCounterNumber(By locator) {
            return driver.findElement(locator).getText();
    }
}
