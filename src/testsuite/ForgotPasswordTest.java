package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //find and click on Forgot password link
        WebElement forgotPassword = driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']"));
        forgotPassword.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        String expectedMessage = "Reset Password";
        String actualMessage = driver.findElement(By.xpath("//button[@type='submit']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);


    }
    @After
    //close the browser
    public void tearDown(){
        closeBrowser();
    }

}
