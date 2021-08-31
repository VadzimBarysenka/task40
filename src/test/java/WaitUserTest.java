import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WaitUserTest {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void WaitForUserTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src, \"https://randomuser.me/\")]")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
