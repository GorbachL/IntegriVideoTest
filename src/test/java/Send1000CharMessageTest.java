import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Send1000CharMessageTest {

    @Test
    public void verifySend1000CharMessage() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webElement = driver.findElement(By.tagName("textarea"));
        webElement.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vitae metus mauris. In hac habitasse platea dictumst. Ut faucibus massa quis lacus lacinia varius. Curabitur porttitor lacus eu enim scelerisque porttitor. Sed eu nunc vestibulum, tincidunt purus vel, volutpat metus. Curabitur lobortis augue sit amet leo luctus rhoncus. Sed venenatis tincidunt nisi sit amet rhoncus. Suspendisse finibus pellentesque leo, in volutpat libero tempus non. Donec ornare nibh eu ipsum scelerisque, tristique tincidunt lorem tincidunt. Sed convallis et nunc nec finibus." +
                "Vivamus pharetra a ante eget pellentesque. Morbi dapibus eleifend nulla, non porta quam blandit sit amet. Vivamus lacinia, urna ac luctus commodo, magna sem tempor velit, nec dignissim purus dui vitae massa. Duis consectetur pharetra nunc, nec blandit nisl cursus eget. Vivamus interdum vel risus ut vestibulum. Donec vehicula sem non leo pulvinar venenatis. Nulla varius quam diam, vel sodales augue pretium ut. Integer luctus massa nunc.");

        WebElement webElement1 = driver.findElement(By.cssSelector(".integri-chat-send-message.integri-chat-action-button"));
        webElement1.click();

        WebElement webElement2 = driver.findElement(By.cssSelector(".integri-chat-message .integri-chat-message-text"));
        int numberOfChars = webElement2.getText().length();
        assertEquals(numberOfChars, 1000, "Number of chars is not correct");

        driver.quit();
    }
}
