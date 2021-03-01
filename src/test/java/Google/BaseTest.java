package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    public GoogleHomePage GHP;

    @BeforeClass
    public void TestSetUp()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @BeforeMethod
    public void methodLevelSetUp()
    {
        GHP = new GoogleHomePage(driver);
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
