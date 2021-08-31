import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class MultiSelectTest {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void MultiSelectRandom() {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Select objSelect = new Select(driver.findElement(By.xpath("//select[@id=\"multi-select\"]")));
        objSelect.selectByIndex(5);
        objSelect.selectByValue("Ohio");
        objSelect.selectByVisibleText("Washington");
        objSelect.getAllSelectedOptions().forEach(WebElement -> System.out.println(WebElement.getText()));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
