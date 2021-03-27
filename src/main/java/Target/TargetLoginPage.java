package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void login(String emailAddress, String password) throws InterruptedException{
        click(AccountBtn);
        Thread.sleep(1000);

        click(SignButton);
        Thread.sleep(5000);
        sendKeys(Input_UserName, emailAddress);
        sendKeys(Input_Password, password);
        Thread.sleep(5000);
        driver.findElement(Button_Login).submit();
        Thread.sleep(1000000);
    }
}
