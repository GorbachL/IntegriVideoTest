import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DownloadFileTest {

    @Test
    public void verifyDownloadFile() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement webElement = driver.findElement(By.cssSelector(".integri-chat-manual-upload.integri-pointer"));
        webElement.click();

        String filePath = "src/test/resources/webdrivers/DownoaldFile1Test";


//        WebElement webElement2 = driver.findElement(By.cssSelector(".integri-file-upload-start.integri-float-right.integri-button-blue"));
//        webElement2.click();



    }
}
