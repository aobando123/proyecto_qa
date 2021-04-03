package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TargetLoginPage extends BasePage{

    private String loginUrl ="https://login.target.com/gsp/static/v1/login/?client_id=ecom-web-1.0.0&ui_namespace=ui-default&back_button_action=browser&keep_me_signed_in=true&kmsi_default=false&actions=create_session_signin";


    TargetLoginPage(WebDriver driver){
        super(driver);
    }

    By AccountBtn = By.id("account");
    By SignButton = By.id("accountNav-signIn");
    By Input_UserName = By.id("username");
    By Input_Password =  By.id("password");
    By Button_Login = By.id("login");
    By Spam_LogonName = By.className("styles__AccountName-sc-1kk0q5l-0");

    public boolean login(String emailAddress, String password) throws InterruptedException{
        click(AccountBtn);
        Thread.sleep(1500);
        click(SignButton);
        Thread.sleep(3000);
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
