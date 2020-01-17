import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class ChangeNameTest {

    @Test
    public void verifyChangeName() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.cssSelector(".iv-icon.iv-icon-cog"));
        webElement.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("[name='userName']")).clear();
        driver.findElement(By.cssSelector("[name='userName']")).sendKeys("New User - Test 10");

        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-user-settings-save.integri-button-blue"));
        webElement1.click();

        driver.navigate().refresh();

        WebElement webElement2 = driver.findElement(By.cssSelector(".integri-session-user-name .integri-session-user-name"));
        assertEquals(webElement2.getText(), "New User - Test 10", "smth went wrong - User Name was NOT changed");

        System.out.println(webElement2.getText());

        driver.quit();
    }
}