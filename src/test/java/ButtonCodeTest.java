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

public class ButtonCodeTest {

    @Test
    public void verifyCodeButton() throws IOException, UnsupportedFlavorException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.cssSelector(".component-code"));
        webElement.click();

        WebElement webElement1 = driver.findElement(By.xpath("//span[contains(text(), 'Code was copied')]"));
        webElement1.isDisplayed();

        String textPopup = webElement1.getText();
        assertEquals(textPopup, "Code was copied", "Info doesn't match");

        String textCode = webElement.getText();
        String textCodeRefactoring = textCode.replaceAll("\n", "");

        String data = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(textCodeRefactoring, data, "Code text does not match");

        System.out.println(textPopup);
        System.out.println(textCodeRefactoring);

        driver.quit();
    }
}
