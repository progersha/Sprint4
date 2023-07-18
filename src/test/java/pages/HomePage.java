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

    private final By faq_section = By.xpath(".//div[@data-accordion-component='Accordion']");
    private final By button_order_header = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By button_order_page = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");
    private final By faq_answer_actual = By.xpath(".//div[(@data-accordion-component='AccordionItemPanel' and not(@hidden))]");

    public String getTextAnswer() {
        new WebDriverWait(webdriver,
                Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(faq_answer_actual));
        return webdriver.findElement(faq_answer_actual).getText();
    }

    public void scrollToFaq() {
        ((JavascriptExecutor)webdriver).executeScript("arguments[0].scrollIntoView();",
                webdriver.findElement(faq_section));
    }

    public void clickFaqItemByText(String text) {
        By element = By.xpath(".//div[@data-accordion-component='AccordionItemButton' and contains(text(),'"+text+"')]");
        webdriver.findElement(element).click();
    }

    public void clickCreateOrderFromHeader() {
        webdriver.findElement(button_order_header).click();
    }

    public void clickCreateOrderFromPage() {
        webdriver.findElement(button_order_page).click();
    }
}
