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
    private final By cookiesButton = By.id("rcc-confirm-button");
    private final By faqSection = By.xpath(".//div[@data-accordion-component='Accordion']");
    private final By buttonOrderHeader = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By buttonOrderPage = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");
    private final By faqAnswerActual = By.xpath(".//div[(@data-accordion-component='AccordionItemPanel' and not(@hidden))]");

    public void acceptCookies() {
        webdriver.findElement(cookiesButton).click();
    }

    public String getTextAnswer() {
        new WebDriverWait(webdriver,
                Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(faqAnswerActual));
        return webdriver.findElement(faqAnswerActual).getText();
    }

    public void scrollToFaq() {
        ((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();",
                webdriver.findElement(faqSection));
    }

    public void clickFaqItemByText(String text) {
        By element = By.xpath(".//div[@data-accordion-component='AccordionItemButton' and contains(text(),'"+text+"')]");
        webdriver.findElement(element).click();
    }

    public void clickCreateOrderFromHeader() {
        webdriver.findElement(buttonOrderHeader).click();
    }

    public void clickCreateOrderFromPage() {
        webdriver.findElement(buttonOrderPage).click();
    }
}
