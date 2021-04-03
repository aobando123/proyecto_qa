package Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TargetDetailPage extends BasePage{

    TargetDetailPage(WebDriver driver){
        super(driver);
    }

    By items_Sold = By.className("styles__StyledTitleLink-mkgs8k-5");
    By H1_Title = By.className("Heading__StyledHeading-sc-1mp23s9-0");
    By Not_Found = By.className("ProductNotFound__Title-sc-18ftl40-1");

    public boolean getDetailElement() throws InterruptedException{
        Thread.sleep(5000);
        List<WebElement> lis = driver.findElements(items_Sold);
        WebElement element = lis.get(0);
        String detailName = element.getText();
        element.click();
        Thread.sleep(5000);
        List<WebElement> titles = driver.findElements(H1_Title);
        WebElement title = titles.get(0);
        Thread.sleep(5000);
        return title.getText().equalsIgnoreCase(detailName);
    }

    public boolean getNotFoundElement() throws InterruptedException{
        driver.navigate().to("https://www.target.com/p/singing-machine-wired-microphone/-/A-5384753#lnk=sametab");
        Thread.sleep(5000);
        WebElement title = driver.findElement(Not_Found);
        return title.getText().equalsIgnoreCase("product not available");
    }
}
