package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver webdriver;

    public HomePage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By FAQ_section = By.xpath(".//div[@data-accordion-component='Accordion']");
    private final By button_order_header = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By button_order_page = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");

    public void waitForVisible(By element) {
        new WebDriverWait(webdriver,
                Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void scrollToFAQ() {
        ((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();",
                webdriver.findElement(FAQ_section));
    }

    public void clickFAQItemByText(String text) {
        By element = By.xpath(".//div[@data-accordion-component='AccordionItemButton' and contains(text(),'"+text+"')]");
        waitForVisible(element);
        webdriver.findElement(element).click();
    }

    public void clickCreateOrderFromHeader() {
        webdriver.findElement(button_order_header).click();
    }

    public void clickCreateOrderFromPage() {
        webdriver.findElement(button_order_page).click();
    }
}
