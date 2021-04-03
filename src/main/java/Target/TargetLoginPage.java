package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TargetLoginPage extends BasePage{

     TargetLoginPage(WebDriver driver){
        super(driver);
    }

    By AccountBtn = By.id("account");
    By SignButton = By.id("accountNav-signIn");
    By Input_UserName = By.id("username");
    By Input_Password =  By.id("password");
    By Button_Login = By.id("login");
    By Spam_LogonName = By.className("styles__AccountName-sc-1kk0q5l-0");
    By Spam_Fail = By.className("sc-kjoXOD");

    public void navigate() throws InterruptedException{
        click(AccountBtn);
        Thread.sleep(1500);
        click(SignButton);
        Thread.sleep(3000);
    }

    public boolean wrongLogin(String emailAddress, String password) throws InterruptedException{
        this.navigate();
        sendKeys(Input_UserName, emailAddress);
        sendKeys(Input_Password, password);
        Thread.sleep(100);
        driver.findElement(Button_Login).submit();
        Thread.sleep(1000);
        WebElement webElement = driver.findElement(Spam_Fail);
        String userName = webElement.getText();
        return userName.equalsIgnoreCase("We can't find your account.");

    }

    public boolean login(String emailAddress, String password) throws InterruptedException{
        WebElement element = driver.findElement(Input_UserName);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);

        WebElement elementPassword = driver.findElement(Input_Password);
        elementPassword.sendKeys(Keys.CONTROL + "a");
        elementPassword.sendKeys(Keys.DELETE);

        Thread.sleep(1000);
        sendKeys(Input_UserName, emailAddress);
        sendKeys(Input_Password, password);
        Thread.sleep(100);
        driver.findElement(Button_Login).submit();
        Thread.sleep(8000);
        WebElement webElement = driver.findElement(Spam_LogonName);
        String userName = webElement.getText();
        return userName.equalsIgnoreCase("Jose");
    }
}
