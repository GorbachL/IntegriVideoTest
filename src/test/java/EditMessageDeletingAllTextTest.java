import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class EditMessageDeletingAllTextTest {

    @Test
    public void verifyEditMessageClearText() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.tagName("textarea"));
        webElement.sendKeys("Test 6");

        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-chat-send-message.integri-chat-action-button"));
        webElement1.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webElement2 = driver.findElement(By.cssSelector(".integri-chat-message .integri-chat-message-text"));
        assertEquals(webElement2.getText(), "Test 7", "smth went wrong");

        WebElement webElement3 = driver.findElement(By.xpath("//span[@class='iv-icon iv-icon-pencil integri-chat-edit-message']"));
        webElement3.click();

        WebElement webElement4 = driver.findElement(By.tagName("textarea"));
        webElement4.clear();
        webElement4.sendKeys(Keys.ENTER);

        WebElement webElement5 = driver.findElement(By.xpath("//*[contains(text(), 'Message cannot be empty!')]"));
        assertEquals(webElement5.getText(), "Message cannot be empty!", "no error");

        driver.quit();
    }
}
