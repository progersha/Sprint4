package test;

import org.junit.Test;
import pages.HomePage;
import pages.OrderPage;

import static org.junit.Assert.assertEquals;

public class OrderTest extends MainTest {

    @Test
    public void checkThatOrderCreatedSuccessfullyFromHeader() {
        HomePage homePage = new HomePage(webdriver);
        homePage.clickCreateOrderFromHeader();
        OrderPage orderPage = new OrderPage(webdriver);
        orderPage.fillOrderClientData("Иван", "Иванов", "Москва, ул. Иванова", "Черкизовская", "89111234567");
        orderPage.clickNextButton();
        orderPage.fillOrderRentData("12.07.2023", "двое суток", "серая безысходность", "no comments");
        orderPage.clickOrderButton();

        assertEquals("Заказ формлен", orderPage.getOrderModalText());
    }

    @Test
    public void checkThatOrderCreatedSuccessfullyFromPage() {
        HomePage homePage = new HomePage(webdriver);
        homePage.clickCreateOrderFromPage();
        OrderPage orderPage = new OrderPage(webdriver);
        orderPage.fillOrderClientData("Петр", "Петров", "Москва, ул. Петрова", "Черкизовская", "89111234568");
        orderPage.clickNextButton();
        orderPage.fillOrderRentData("15.07.2023", "трое суток", "чёрный жемчуг", "yes comments");
        orderPage.clickOrderButton();

        assertEquals("Заказ формлен", orderPage.getOrderModalText());
    }
}
