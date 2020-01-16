import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ChangeEmailTest {

    @Test
    public void verifyChangeName() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.cssSelector(".iv-icon.iv-icon-cog"));
        webElement.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("[name='userName']")).sendKeys(Keys.TAB);
        driver.findElement(By.cssSelector("[name='userEmail']")).sendKeys("Test11@mail.ru");

        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-user-settings-save.integri-button-blue"));
        webElement1.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webElement = driver.findElement(By.cssSelector(".iv-icon.iv-icon-cog"));
        webElement.click();

        WebElement webElement2 = driver.findElement(By.cssSelector("[name='userEmail']"));
        String userEmail = webElement2.getAttribute("value");

        assertEquals(userEmail, "Test11@mail.ru", "smth went wrong - User Email was NOT saved");

        System.out.println(userEmail);

        driver.quit();
    }
}
