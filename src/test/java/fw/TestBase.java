package fw;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {


    protected final ApplicationManager app = new ApplicationManager();


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
    }

    @AfterMethod
    public void tearDown() throws MalformedURLException {
        app.stop();
    }

}
