package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver webdriver;

    public OrderPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    private final By last_name = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metro = By.xpath(".//div[@class='select-search']");
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By duration = By.xpath(".//div[@class='Dropdown-root']");
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By next_button = By.xpath(".//button[contains(text(),'Далее')]");
    private final By order_button = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By order_confirm_modal_header = By.xpath("(.//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?'])");
    private final By order_success_modal_header = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public void setMetroStation(String nameStation) {
        webdriver.findElement(metro).click();
        By station = By.xpath(".//*[(@class='Order_Text__2broi' and text()='" + nameStation + "')]");
        webdriver.findElement(station).click();
    }

    public void fillOrderClientData(String name, String lastname, String address, String metro, String phone){
        webdriver.findElement(this.name).sendKeys(name);
        webdriver.findElement(last_name).sendKeys(lastname);
        webdriver.findElement(this.address).sendKeys(address);
        setMetroStation(metro);
        webdriver.findElement(this.phone).sendKeys(phone);
    }

    public void clickNextButton() {
        webdriver.findElement(next_button).click();
    }

    public void setDuration(String days) {
        webdriver.findElement(duration).click();
        By duration = By.xpath(".//div[@class='Dropdown-menu']/div['" + days + "']");
        webdriver.findElement(duration).click();
    }

    public void setColor(String colorName) {
        By color = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label['" + colorName + "']/input");
        webdriver.findElement(color).click();
    }

    public void fillOrderRentData(String date, String duration, String color, String comment) {
        webdriver.findElement(this.date).sendKeys(date, Keys.ENTER);
        setDuration(duration);
        setColor(color);
        webdriver.findElement(this.comment).sendKeys(comment);
    }

    public void clickOrderButton() {
        webdriver.findElement(order_button).click();
    }

    public String getOrderModalText() {
        new WebDriverWait(webdriver,
                Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(order_confirm_modal_header));
        return webdriver.findElement(order_success_modal_header).getText();
    }
}