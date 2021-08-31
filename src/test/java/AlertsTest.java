import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class AlertsTest {
    private final String USER_NAME = "UserName";
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void AlertConfirmTest() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//button[@onclick=\"myConfirmFunction()\"]")).click();
        driver.switchTo().alert().accept();
        WebElement confirmMessage = driver.findElement(By.xpath("//p[@id=\"confirm-demo\"]"));

        Assert.assertEquals("You pressed OK!", confirmMessage.getText());
    }

    @Test
    public void AlertDismissTest() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//button[@onclick=\"myConfirmFunction()\"]")).click();
        driver.switchTo().alert().dismiss();
        WebElement confirmMessage = driver.findElement(By.xpath("//p[@id=\"confirm-demo\"]"));

        Assert.assertEquals("You pressed Cancel!", confirmMessage.getText());
    }

    @Test
    public void AlertEnterTextTest() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        WebDriverWait accName = new WebDriverWait(driver, 15);
        accName.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Java Script Confirm Box\"]")));
        driver.findElement(By.xpath("//button[@onclick=\"myPromptFunction()\"]")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(USER_NAME);
        alert.accept();
        WebElement confirmMessage = driver.findElement(By.xpath("//p[@id=\"prompt-demo\"]"));

        Assert.assertEquals("You have entered '" + USER_NAME + "' !", confirmMessage.getText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
