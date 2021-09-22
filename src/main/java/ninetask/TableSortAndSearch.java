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

        for (WebElement page : pages) {
            List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr"));

            for (WebElement element : allRows) {
                WebElement age = element.findElement(By.xpath("td[4]"));
                WebElement salary = element.findElement(By.xpath("td[6]"));
                int employeeAge = Integer.parseInt(age.getText());
                double employeeSalary = Double.parseDouble(salary.getText().substring(1).replaceAll("/y", "").replaceAll(",", ""));

                if (employeeAge > requiredAge & employeeSalary <= requiredSalary) {
                    WebElement name = element.findElement(By.xpath("td[1]"));
                    WebElement position = element.findElement(By.xpath("td[2]"));
                    WebElement office = element.findElement(By.xpath("td[3]"));
                    Employee employee = new Employee(name.getText(), position.getText(), office.getText());
                    employees.add(employee);
                }
            }
            driver.findElement(By.xpath("//a[@id=\"example_next\"]")).click();
        }
        driver.close();
        return employees;
    }
}
