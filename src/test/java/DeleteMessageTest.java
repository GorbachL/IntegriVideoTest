import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DeleteMessageTest {

    @Test
    public void verifyDeleteMessage() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.tagName("textarea"));
        webElement.sendKeys("Test 8");

        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-chat-send-message.integri-chat-action-button"));
        webElement1.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webElement2 = driver.findElement(By.cssSelector(".integri-chat-message .integri-chat-message-text"));
        assertEquals(webElement2.getText(), "Test 8", "smth went wrong");

        WebElement webElement3 = driver.findElement(By.xpath("//span[@class='iv-icon iv-icon-trash2 integri-chat-remove-message']"));
        webElement3.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement webElement4 = driver.findElement(By.cssSelector(".integri-chat-message.integri-chat-message-utility"));
        assertEquals(webElement4.getText(), "removed...", "smth went wrong");

        driver.quit();
    }
}
