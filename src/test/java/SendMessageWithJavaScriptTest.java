import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SendMessageWithJavaScriptTest {

    @Test
    public void verifySendMessageWithJavaScript() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.tagName("textarea"));
        webElement.sendKeys("<html><body><p>test 5</p></body></html>");
        webElement.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-chat-message .integri-chat-message-text"));
        assertEquals(webElement1.getText(), "test 5", "smth went wrong");

        driver.quit();
    }
}
