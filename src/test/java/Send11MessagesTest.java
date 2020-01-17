import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Send11MessagesTest {

    @Test
    public void verifySend11Messages() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.cssSelector("[placeholder]"));
        webElement.sendKeys("Test 9 - 1\n" +
//                "Test 9 - 2\n" +
//                "Test 9 - 3\n" +
//                "Test 9 - 4\n" +
//                "Test 9 - 5\n" +
//                "Test 9 - 6\n" +
//                "Test 9 - 7\n" +
//                "Test 9 - 8\n" +
//                "Test 9 - 9\n" +
//                "Test 9 - 10\n" +
//                "Test 9 - 11\n" +
                "Test 9 - 12\n");
        webElement.sendKeys("222\n");
        webElement.sendKeys("3\n");
        webElement.sendKeys("4\n");
        webElement.sendKeys("5\n");
        webElement.sendKeys("6\n");
        webElement.sendKeys("7\n");
        webElement.sendKeys("8\n");
        webElement.sendKeys("9\n");
        webElement.sendKeys("10\n");
        webElement.sendKeys("11\n");
        webElement.sendKeys(Keys.ENTER);

        WebElement webElement2 = driver.findElement(By.cssSelector("[placeholder]"));
        webElement2.sendKeys("should fail");
        webElement2.sendKeys(Keys.ENTER);

//        WebElement webElement3 = driver.findElement(By.tagName("textarea"));
//        webElement3.sendKeys("Test 9 - 3");
//        webElement3.sendKeys(Keys.ENTER);
//
//        WebElement webElement4 = driver.findElement(By.tagName("textarea"));
//        webElement4.sendKeys("Test 9 - 4");
//        webElement4.sendKeys(Keys.ENTER);
//
//        WebElement webElement5 = driver.findElement(By.tagName("textarea"));
//        webElement5.sendKeys("Test 9 - 5");
//        webElement5.sendKeys(Keys.ENTER);
//
//        WebElement webElement6 = driver.findElement(By.tagName("textarea"));
//        webElement6.sendKeys("Test 9 - 6");
//        webElement6.sendKeys(Keys.ENTER);
//
//        WebElement webElement7 = driver.findElement(By.tagName("textarea"));
//        webElement7.sendKeys("Test 9 - 7");
//        webElement7.sendKeys(Keys.ENTER);
//
//        WebElement webElement8 = driver.findElement(By.tagName("textarea"));
//        webElement8.sendKeys("Test 9 - 8");
//        webElement8.sendKeys(Keys.ENTER);
//
//        WebElement webElement9 = driver.findElement(By.tagName("textarea"));
//        webElement9.sendKeys("Test 9 - 9");
//        webElement9.sendKeys(Keys.ENTER);
//
//        WebElement webElement10 = driver.findElement(By.tagName("textarea"));
//        webElement10.sendKeys("Test 9 - 10");
//        webElement10.sendKeys(Keys.ENTER);
//
//        WebElement webElement11 = driver.findElement(By.tagName("textarea"));
//        webElement11.sendKeys("Test 9 - 11");
//        webElement11.sendKeys(Keys.ENTER);
//
//        WebElement webElement12 = driver.findElement(By.tagName("textarea"));
//        webElement12.sendKeys("Test 9 - 12\n");
//        WebElement webElement13 = driver.findElement(By.cssSelector(".integri-chat-send-message.integri-chat-action-button"));
//        webElement13.click();


//        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-chat-send-message.integri-chat-action-button"));
//        webElement1.click();
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        WebElement webElement2 = driver.findElement(By.cssSelector(".integri-chat-message .integri-chat-message-text"));
//        assertEquals(webElement2.getText(), "Test 9 - 1", "smth went wrong");
    }
}
