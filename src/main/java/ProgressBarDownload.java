import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBarDownload {

    public void progressBarRefreshAfterFifty() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        driver.findElement(By.xpath("//button[@class=\"btn btn-block btn-primary\"]")).click();
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.textToBe(By.xpath("//div[@class=\"percenttext\"]"), "50%"));
        driver.navigate().refresh();
    }
}
