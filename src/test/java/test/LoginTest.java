package test;

import fw.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    public static final String ITEMS_CONTAINER_XPATH = "//android.view.ViewGroup[@content-desc='products screen']/android.widget.ScrollView";

    @Test
    public void testLoginPositive() {
        String validEmail = "bob@example.com";
        String validPwd = "10203040";


        app.getHeaderHelper().waitForMenuBtnToLoad();
        app.getHeaderHelper().clickOnMenuBtn();
        app.getMenuHelper().waitForMenuToLoad();
        app.getMenuHelper().clickOnLogin();
        app.getLoginScreenHelper().login(validEmail, validPwd);
        app.getItemContainerHelper().waitToLoad(By.xpath(ITEMS_CONTAINER_XPATH));
        Assert.assertTrue(app.getItemContainerHelper().waitToLoad(By.xpath(ITEMS_CONTAINER_XPATH)) != null, "Items page is loaded.");
    }

    @Test
    public void testLoginNegativeInvalidEmail() {
        String invalidEmail = "invalidemail@example.com";
        String validPwd = "10203040";
        String expectedErrMsgTxt = "Provided credentials do not match any user in this service.";


        app.getHeaderHelper().waitForMenuBtnToLoad();
        app.getHeaderHelper().clickOnMenuBtn();
        app.getMenuHelper().waitForMenuToLoad();
        app.getMenuHelper().clickOnLogin();
        app.getLoginScreenHelper().login(invalidEmail, validPwd);
        app.getLoginScreenHelper().waitForErrorMsgToAppear();
        Assert.assertEquals(app.getLoginScreenHelper().getErrorMsgText(), expectedErrMsgTxt, "Following error message appears: '" + expectedErrMsgTxt + "'");
    }

    @Test
    public void testLoginNegativeInvalidPwd() {
        String validEmail = "bob@example.com";
        String invalidPwd = "1111";
        String expectedErrMsgTxt = "Provided credentials do not match any user in this service.";


        app.getHeaderHelper().waitForMenuBtnToLoad();
        app.getHeaderHelper().clickOnMenuBtn();
        app.getMenuHelper().waitForMenuToLoad();
        app.getMenuHelper().clickOnLogin();
        app.getLoginScreenHelper().login(validEmail, invalidPwd);
        app.getLoginScreenHelper().waitForErrorMsgToAppear();
        Assert.assertEquals(app.getLoginScreenHelper().getErrorMsgText(), expectedErrMsgTxt, "Following error message appears: '" + expectedErrMsgTxt + "'");
    }

    @Test
    public void testLoginNegativeEmptyEmailInputField() {
        String emptyEmail = "";
        String validPwd = "10203040";
        String expectedErrMsgTxt = "Username is required";


        app.getHeaderHelper().waitForMenuBtnToLoad();
        app.getHeaderHelper().clickOnMenuBtn();
        app.getMenuHelper().waitForMenuToLoad();
        app.getMenuHelper().clickOnLogin();
        app.getLoginScreenHelper().login(emptyEmail, validPwd);
        app.getLoginScreenHelper().waitForEmptyEmailErrorMsgToAppear();
        Assert.assertEquals(app.getLoginScreenHelper().getEmptyEmailErrorMsgText(), expectedErrMsgTxt, "Following error message appears: '" + expectedErrMsgTxt + "'");
        //app.getLoginScreenHelper().waitForErrorMsgToAppear();
        //Assert.assertEquals(app.getLoginScreenHelper().getErrorMsgText(), expectedErrMsgTxt, "Following error message appears: '" + expectedErrMsgTxt + "'");
    }

    @Test
    public void testLoginNegativeEmptyPwdInputField() {
        String validEmail = "bob@example.com";
        String emptyPwd = "";
        String expectedErrMsgTxt = "Password is required";


        app.getHeaderHelper().waitForMenuBtnToLoad();
        app.getHeaderHelper().clickOnMenuBtn();
        app.getMenuHelper().waitForMenuToLoad();
        app.getMenuHelper().clickOnLogin();
        app.getLoginScreenHelper().login(validEmail, emptyPwd);
        app.getLoginScreenHelper().waitForEmptyPwdErrorMsgToAppear();
        Assert.assertEquals(app.getLoginScreenHelper().getEmptyPswErrorMsgText(), expectedErrMsgTxt, "Following error message appears: '" + expectedErrMsgTxt + "'");
        //app.getLoginScreenHelper().waitForErrorMsgToAppear();
        //Assert.assertEquals(app.getLoginScreenHelper().getErrorMsgText(), expectedErrMsgTxt, "Following error message appears: '" + expectedErrMsgTxt + "'");

    }



}
