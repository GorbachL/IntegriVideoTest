import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Send11MessagesTest {

    @Test
    public void verifySend11Messages() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.cssSelector("[placeholder]"));
        webElement.sendKeys("Test 9 - 1\n" +
                "Test 9 - 2\n" +
                "Test 9 - 3\n");

        webElement.sendKeys(Keys.ENTER);

    }
}
