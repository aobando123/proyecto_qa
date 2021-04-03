package Target;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTargetLogin extends BaseTest{
    public TargetLoginPage TLP;

    @BeforeMethod
    public void methodLevelSetUp()
    {
        TLP = new TargetLoginPage(driver);
    }

    @Test
    public void testLogin() throws InterruptedException {
        Assert.assertTrue(TLP.login("jsolanom@ucenfotec.ac.cr", "testU123"));
    }

}
