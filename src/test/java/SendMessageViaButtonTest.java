import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SendMessageViaButtonTest {

    @Test
    public void verifySendMessageViaButton() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.tagName("textarea"));
        webElement.sendKeys("test 2");

        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-chat-send-message.integri-chat-action-button"));
        webElement1.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webElement2 = driver.findElement(By.cssSelector(".integri-chat-message .integri-chat-message-text"));
        assertEquals(webElement2.getText(), "test 2", "smth went wrong");

        driver.quit();
    }
}

