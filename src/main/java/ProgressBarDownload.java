
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class ProgressBarDownload {

    public void progressBarRefreshAfterFifty() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        driver.findElement(By.xpath("//button[@class=\"btn btn-block btn-primary\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) driver1 -> {
            WebElement progressBar = driver1.findElement(By.xpath("//div[@class=\"percenttext\"]"));
            if (progressBar != null) {
                if (Integer.parseInt(progressBar.getText().replaceAll("%", "")) >= 50) {
                    driver1.navigate().refresh();
                    return true;
                }
            }
            return false;
        });
    }
}



