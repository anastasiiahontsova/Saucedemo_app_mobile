package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MenuHelper extends BaseHelper {

    public static final String LOG_IN_XPATH = "//android.view.ViewGroup[@content-desc='menu item log in']";
    public static final String ABOUT_XPATH = "//android.view.ViewGroup[@content-desc='menu item about']";



    public MenuHelper(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnLogin() {
        waitUntilElementIsClickable(By.xpath(LOG_IN_XPATH));
        tap(By.xpath(LOG_IN_XPATH));
    }

    public void waitForMenuToLoad() {
        waitUntilElementIsClickable(By.xpath(ABOUT_XPATH));
    }
}
