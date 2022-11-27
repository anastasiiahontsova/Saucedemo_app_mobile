package test;

import fw.TestBase;
import org.testng.annotations.Test;

public class DeepLinks extends TestBase {

    @Test
    public void deepLinkDemo(){
        app.openDeepLink("login");
        app.getLoginHelper().waitToLoad();
        app.openDeepLink("store-overview");
        app.getProductsContainerHelper().waitToLoad();

    }
}
