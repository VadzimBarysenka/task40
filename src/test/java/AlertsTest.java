
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlertsTest {
    private final String USER_NAME = "UserName";
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void alertConfirmTest() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//button[@onclick=\"myConfirmFunction()\"]")).click();
        driver.switchTo().alert().accept();
        WebElement confirmMessage = driver.findElement(By.xpath("//p[@id=\"confirm-demo\"]"));

        assertEquals("You pressed OK!", confirmMessage.getText());
    }

    @Test
    public void alertDismissTest() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//button[@onclick=\"myConfirmFunction()\"]")).click();
        driver.switchTo().alert().dismiss();
        WebElement confirmMessage = driver.findElement(By.xpath("//p[@id=\"confirm-demo\"]"));

        assertEquals("You pressed Cancel!", confirmMessage.getText());
    }

    @Test
    public void alertEnterTextTest() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        WebDriverWait accName = new WebDriverWait(driver, 15);
        accName.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Java Script Confirm Box\"]")));
        driver.findElement(By.xpath("//button[@onclick=\"myPromptFunction()\"]")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(USER_NAME);
        alert.accept();
        WebElement confirmMessage = driver.findElement(By.xpath("//p[@id=\"prompt-demo\"]"));

        assertEquals("You have entered '" + USER_NAME + "' !", confirmMessage.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
