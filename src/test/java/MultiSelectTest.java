
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultiSelectTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void multiSelectRandom() {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Select objSelect = new Select(driver.findElement(By.xpath("//select[@id=\"multi-select\"]")));
        objSelect.selectByIndex(5);
        objSelect.selectByValue("Ohio");
        objSelect.selectByVisibleText("Washington");

        List<String> expectedValues = new ArrayList<>();
        expectedValues.add("Ohio");
        expectedValues.add("Texas");
        expectedValues.add("Washington");

        List<String> actualValues = objSelect.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());

        assertEquals(expectedValues, actualValues);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
