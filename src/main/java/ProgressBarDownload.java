
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProgressBarDownload {
    public static void main(String[] args) {
        // public void progressBarRefreshAfterFifty() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        driver.findElement(By.xpath("//button[@class=\"btn btn-block btn-primary\"]")).click();

        WebElement progressBar = driver.findElement(By.xpath("//div[@class=\"percenttext\"]"));

        while (progressBar.isDisplayed()) {
            if (Integer.parseInt(progressBar.getText().replaceAll("%", "")) >= 50) {
                driver.navigate().refresh();
                break;
            }
        }
    }
}
