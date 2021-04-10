package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TargetPasswordRecoveryPage extends BasePage{

    TargetPasswordRecoveryPage(WebDriver driver){
        super(driver);
    }

    By AccountBtn = By.id("account");
    By SignButton = By.id("accountNav-signIn");
    By RecoveryPassword = By.id("recoveryPassword");
    By Input_UserName = By.id("username");
    By Button_Continue = By.id("continue");
    By Spam_Fail = By.className("sc-kjoXOD");
    By Spam_Success = By.className("sc-cvbbAY");

    private void navigate() throws InterruptedException{
        click(AccountBtn);
        Thread.sleep(1500);
        click(SignButton);
        Thread.sleep(3000);
        click(RecoveryPassword);
        Thread.sleep(1000);
    }

    public boolean recoveryPasswordFail(String emailAddress)throws InterruptedException{
        this.navigate();
        sendKeys(Input_UserName, emailAddress);
        Thread.sleep(500);
        driver.findElement(Button_Continue).submit();
        Thread.sleep(500);
        driver.findElement(Button_Continue).submit();
        WebElement webElement = driver.findElement(Spam_Fail);
        return webElement.getText().equalsIgnoreCase("We can't find your account.");
    }

    public boolean recoveryPassword(String emailAddress)throws InterruptedException{
        driver.navigate().back();
        this.navigate();
        sendKeys(Input_UserName, emailAddress);
        Thread.sleep(1500);
        driver.findElement(Button_Continue).submit();
        Thread.sleep(500);
        driver.findElement(Button_Continue).submit();
        Thread.sleep(900);
        WebElement webElement = driver.findElement(Spam_Success);
        return webElement.getText().equalsIgnoreCase("Verification code sent");
    }

}
