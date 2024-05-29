package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username element and enter username "Admin"
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        //Find password element and enter password "admin123"
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        //find loginbutton and click on loginbutton
        WebElement loginButton= driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String expectedMessage = "Dashboard";
        String actualMessage = driver.findElement(By.tagName("h6")).getText();
       Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    //close the browser
    public void tearDown(){
        closeBrowser();
    }
}
