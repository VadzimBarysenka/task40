package ninetask;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class TableSortAndSearch {

    public List<Employee> tableSearch(int requiredAge, int requiredSalary) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
        new Select(driver.findElement(By.xpath("//select"))).selectByValue("10");
        List<WebElement> pages = driver.findElements(By.xpath("//span//a[contains(@class, \"paginate_button \")]"));
        List<Employee> employees = new ArrayList<>();

        for (int p = 0; p < pages.size() - 1; p++) {
            List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr"));

            for (int i = 1; i <= allRows.size(); i++) {
                WebElement age = driver.findElement(By.xpath("//tr[" + i + "]/td[4]"));
                WebElement salary = driver.findElement(By.xpath("//tr[" + i + "]/td[6]"));

                if (Integer.parseInt(age.getText()) == requiredAge & Integer.parseInt(salary.getText().substring(1).replaceAll("/y", "").replaceAll(",", "")) <= requiredSalary) {
                    WebElement name = driver.findElement(By.xpath("//tr[" + i + "]/td[1]"));
                    WebElement position = driver.findElement(By.xpath("//tr[" + i + "]/td[2]"));
                    WebElement office = driver.findElement(By.xpath("//tr[" + i + "]/td[3]"));
                    Employee e = new Employee(name.getText(), position.getText(), office.getText());
                    employees.add(e);
                }
            }
            driver.findElement(By.xpath("//a[@class=\"paginate_button next\"]")).click();
        }
        driver.close();
        return employees;
    }
}
