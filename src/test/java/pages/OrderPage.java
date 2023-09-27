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

    private By name = By.xpath(".//input[@placeholder='* Имя']");
    private By lastName = By.xpath(".//input[@placeholder='* Фамилия']");
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metro = By.xpath(".//div[@class='select-search']");
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By duration = By.xpath(".//div[@class='Dropdown-root']");
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By nextButton = By.xpath(".//button[contains(text(),'Далее')]");
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By applyButton = By.xpath(".//button[text()='Да']");
    private By orderSuccessModalHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public void setMetroStation(String nameStation) {
        webdriver.findElement(metro).click();
        By station = By.xpath(".//*[(@class='Order_Text__2broi' and text()='" + nameStation + "')]");
        webdriver.findElement(station).click();
    }

    public void fillOrderClientData(String name, String lastname, String address, String metro, String phone){
        webdriver.findElement(this.name).sendKeys(name);
        webdriver.findElement(lastName).sendKeys(lastname);
        webdriver.findElement(this.address).sendKeys(address);
        setMetroStation(metro);
        webdriver.findElement(this.phone).sendKeys(phone);
    }

    public void clickNextButton() {
        webdriver.findElement(nextButton).click();
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
        webdriver.findElement(orderButton).click();
    }

    public void clickApplyButton() {
        webdriver.findElement(applyButton).click();
    }

    public String getOrderModalText() {
        new WebDriverWait(webdriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderSuccessModalHeader));
        String[] modal_header = webdriver.findElement(orderSuccessModalHeader).getText().split("\n");
        return modal_header[0];
    }
}