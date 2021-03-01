package Google;

import Google.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestGooglePage extends BaseTest{

    @Test
    public void primerTest()
    {
        GHP.clickGoogle("Universidad Cenfotec");
    }

}
