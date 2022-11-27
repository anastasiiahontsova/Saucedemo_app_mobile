package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MenuHelper extends BaseHelper {

    public static final String LOG_IN_XPATH = "//android.view.ViewGroup[@content-desc='menu item log in']";
    public static final String ABOUT_XPATH = "//android.view.ViewGroup[@content-desc='menu item about']";
    public static final String RESET_APP_STATE_BTN_XPATH = "//android.view.ViewGroup[@content-desc='menu item reset app']";
    public static final String CATALOG_BTN_XPATH = "//android.view.ViewGroup[@content-desc='open menu']";


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

    public void resetAppState() {
        openMenu();
        waitUntilElementIsClickable(By.xpath(RESET_APP_STATE_BTN_XPATH));
        tap(By.xpath(RESET_APP_STATE_BTN_XPATH));
        tap(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"));
        waitUntilElementIsPresent(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
        tap(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"));
        waitUntilElementIsClickable(By.xpath(CATALOG_BTN_XPATH));
        tap(By.xpath(CATALOG_BTN_XPATH));
    }
}
