package com.yandex;
// user: someuserfortest
// pass: !QAZxsw2
// user: someanotheruserfortest
// pass: #EDCvfr4

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertAll;

//@RunWith(Parameterized.class)
public class LoginPageTest {
    WebDriver driver;
/*
    @Parameterized.Parameters
    public static Collection<Object[]> users() {
        return Arrays.asList(new Object[][]{
                        {"someuserfortest", "!QAZxsw2"},
                        {"someanotheruserfortest", "#EDCvfr4"}
                }
        );
    }

    private final String username, password;

    public LoginPageTest(String username, String password) {
        this.username = username;
        this.password = password;
    }
 */
    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void login(String username, String password) throws InterruptedException {
        driver.get("https://mail.yandex.com/");
        WebElement enterPage = driver.findElement(By.xpath("//a[contains(@class, \"HeadBanner-Button-Enter\")]"));
        enterPage.click();
        WebElement loginField = driver.findElement(By.id("passp-field-login"));
        loginField.sendKeys(username);
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
        WebElement passField = driver.findElement(By.id("passp-field-passwd"));
        passField.click();
        passField.sendKeys(password);
        WebElement signIn = driver.findElement(By.id("passp:sign-in"));
        signIn.click();
        Thread.sleep(1000); // none?
        WebDriverWait accName = new WebDriverWait(driver, 3);
        accName.until(ExpectedConditions.presenceOfElementLocated(By.className("user-account__name")));
        WebElement inbox = driver.findElement(By.xpath("//a[contains(@title, \"Inbox\")]"));
        String expectedTitle = "Inbox — Yandex.Mail";

        assertAll(
                () -> Assertions.assertEquals(driver.getTitle(), expectedTitle),
                () -> Assertions.assertEquals(inbox.getText(), "Inbox"));
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("someuserfortest", "!QAZxsw2"),
                arguments("someanotheruserfortest", "#EDCvfr4")
        );
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
