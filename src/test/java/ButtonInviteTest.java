import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ButtonInviteTest {

    @Test
    public void verifyInviteButton() throws IOException, UnsupportedFlavorException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.xpath("//*[contains(text(), 'Invite users to chat')]"));
        webElement.click();

        WebElement webElement1 = driver.findElement(By.xpath("//span[contains(text(), 'Link was copied')]"));
        webElement1.isDisplayed();

        String textPopup = webElement1.getText();
        assertEquals(textPopup, "Link was copied", "Info doesn't match");

        String textLink = driver.getCurrentUrl();

        String data = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(textLink, data, "Link does not match");

        System.out.println(textPopup);
        System.out.println(textLink);

        driver.quit();
    }
}
