import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBarDownload {

    public void progressBarRefreshAfterFifty() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        driver.findElement(By.xpath("//button[@class=\"btn btn-block btn-primary\"]")).click();
        WebDriverWait a = new WebDriverWait(driver, 30);
        a.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"slice clipauto\"]")));
        driver.navigate().refresh();
    }
}
