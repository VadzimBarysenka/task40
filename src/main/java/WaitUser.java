import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUser {

    public void waitForUser() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[contains(@src, \"https://randomuser.me/\")]")));
    }
}
