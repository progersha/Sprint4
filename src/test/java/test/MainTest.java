package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class MainTest {
    WebDriver webdriver;

    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By cookies_button = By.id("rcc-confirm-button");

    private void acceptCookies() {
        webdriver.findElement(cookies_button).click();
    }

    @Before
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webdriver = new ChromeDriver(options);
        webdriver.get(url);
        acceptCookies();
    }

    @After
    public void teardown() {
        webdriver.quit();
    }
}
