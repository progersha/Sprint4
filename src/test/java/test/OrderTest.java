package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.OrderPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderTest extends MainTest {

    private final String NAME;
    private final String LASTNAME;
    private final String ADDRESS;
    private final String METRO;
    private final String PHONE;
    private final String DATE;
    private final String DURATION;
    private final String COLOR;
    private final String COMMENT;

    public OrderTest(String name,
                     String lastname,
                     String address,
                     String metro,
                     String phone,
                     String date,
                     String duration,
                     String color,
                     String comment) {
        this.NAME = name;
        this.LASTNAME = lastname;
        this.ADDRESS = address;
        this.METRO = metro;
        this.PHONE = phone;
        this.DATE = date;
        this.DURATION = duration;
        this.COLOR = color;
        this.COMMENT = comment;
    }

    @Parameterized.Parameters
    public static Object[][] orderParams() {
        return new Object[][]{
            {
                "Иван",
                "Иванов",
                "Москва, ул. Иванова",
                "Черкизовская",
                "89111234567",
                "12.07.2023",
                "двое суток",
                "серая безысходность",
                "no comments"
            },
            {
                "Петр",
                "Петров",
                "Москва, ул. Петрова",
                "Черкизовская",
                "89111234568",
                "15.07.2023",
                "трое суток",
                "чёрный жемчуг",
                "yes comments"
            },
        };
    }

    @Test
    public void checkThatOrderCreatedSuccessfullyFromHeader() {
        HomePage homePage = new HomePage(webdriver);
        homePage.clickCreateOrderFromHeader();
        OrderPage orderPage = new OrderPage(webdriver);
        orderPage.fillOrderClientData(NAME, LASTNAME, ADDRESS, METRO, PHONE);
        orderPage.clickNextButton();
        orderPage.fillOrderRentData(DATE,DURATION, COLOR, COMMENT);
        orderPage.clickOrderButton();

        assertEquals(orderPage.getOrderModalText(), "Заказ формлен");
    }

    @Test
    public void checkThatOrderCreatedSuccessfullyFromPage() {
        HomePage homePage = new HomePage(webdriver);
        homePage.clickCreateOrderFromPage();
        OrderPage orderPage = new OrderPage(webdriver);
        orderPage.fillOrderClientData(NAME, LASTNAME, ADDRESS, METRO, PHONE);
        orderPage.clickNextButton();
        orderPage.fillOrderRentData(DATE,DURATION, COLOR, COMMENT);
        orderPage.clickOrderButton();

        assertEquals(orderPage.getOrderModalText(), "Заказ формлен");
    }
}
