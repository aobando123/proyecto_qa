package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestTargetShoppingCart extends BaseTest{
    TargetLoginPage TLP;
    TargetShoppingCart TSC;
    By cardItems = By.xpath("//*[@data-test='cartItem']");

    @BeforeMethod
    public void methodLevelSetUp()
    {
        TLP =  new TargetLoginPage(driver);
        TSC = new TargetShoppingCart(driver);
    }

    @Test
    public void addItemToCart()throws InterruptedException {
        TLP.navigate();
        TLP.login("cobandol@ucenfotec.ac.cr", "Welcome!!");
        Thread.sleep(1000);
        TSC.addItemToCart();
        List<WebElement> cartItems = driver.findElements(cardItems);
        Assert.assertTrue(!cartItems.isEmpty());

    }
    @Test
    public void deleteItemfromCart()throws InterruptedException {
        driver.get("https://www.target.com/");
        Thread.sleep(1000);
        TSC.deleteItemFromCart();
        List<WebElement> cartItems = driver.findElements(cardItems);
        Assert.assertTrue(cartItems.isEmpty());
    }

}
