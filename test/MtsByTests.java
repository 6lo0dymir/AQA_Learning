import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.PaymentPopUpWindow;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("Тесты сайта МТС")
public class MtsByTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    @Step("Запуск браузера, открытие сайта МТС и принятие cookies")
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mts.by");

        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока")
    @Description("Тест проверяет, что заголовок блока содержит правильный текст")
    public void testBlockName() {
        String title = homePage.getBlockTitle();

        boolean hasCorrectText = title.contains("Онлайн пополнение") || title.contains("без комиссии");
        assertTrue(hasCorrectText, "Название блока не соответствует ожидаемому");
    }

    @Test
    @Order(2)
    @DisplayName("Проверка логотипов платежных систем")
    @Description("Проверка отображения всех логотипов платежных систем на главной странице")
    public void testPaymentSystemLogo() {
        boolean allLogosDisplayed = homePage.checkLogos();
        assertTrue(allLogosDisplayed, "Не все логотипы платежных систем отображаются");
    }

    @Test
    @Order(3)
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    @Description("Проверка, что при клике на ссылку происходит переход на страницу 'Подробнее о сервисе'")
    public void testMoreAboutServiceLink() {
        String oldUrl = homePage.getCurrentUrl();

        homePage.clickMoreAboutService();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String newUrl = homePage.getCurrentUrl();
        Allure.step("Сравнить текущий и ранее полученный Url");
        assertNotEquals(oldUrl, newUrl, "URL должен измениться после клика на ссылку");
    }

    @Test
    @Order(4)
    @DisplayName("Проверка плейсхолдеров")
    @Description("Проверка плейсхолдеров для всех вариантов оплаты")
    public void testAllPaymentOptionsPlaceholders() {
        homePage.selectPaymentOption("Услуги связи");
        assertEquals("Номер телефона", homePage.getServicesPhonePlaceholder());
        assertEquals("Сумма", homePage.getServicesAmountPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getServicesEmailPlaceholder());

        homePage.selectPaymentOption("Домашний интернет");
        assertEquals("Номер абонента", homePage.getInternetPhonePlaceholder());
        assertEquals("Сумма", homePage.getInternetAmountPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getInternetEmailPlaceholder());

        homePage.selectPaymentOption("Рассрочка");
        assertEquals("Номер счета на 44", homePage.getInstalmentPhonePlaceholder());
        assertEquals("Сумма", homePage.getInstalmentAmountPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getInstalmentEmailPlaceholder());

        homePage.selectPaymentOption("Задолженность");
        assertEquals("Номер счета на 2073", homePage.getArrearsPhonePlaceholder());
        assertEquals("Сумма", homePage.getArrearsAmountPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getArrearsEmailPlaceholder());
    }

    @Test
    @Order(5)
    @DisplayName("Проверка оплаты")
    @Description("Тест оплаты и названия полей")
    public void testPhonePaymentForm() {
        homePage.selectPaymentOption("Услуги связи");
        homePage.fillServicesForm("297777777", "100.00", "test@mail.ru");
        homePage.clickContinueButton();

        PaymentPopUpWindow popup = new PaymentPopUpWindow(driver);

        assertEquals("100.00 BYN", popup.getAmountOnCard());
        assertEquals("Оплатить 100.00 BYN", popup.getAmountOnButton());
        assertTrue(popup.getPhoneNumber().contains("297777777"));
        assertEquals("Номер карты", popup.getCardNumberLabelText());
        assertEquals("Срок действия", popup.getExpiryDateLabelText());
        assertEquals("CVC", popup.getCvcLabelText());
        assertTrue(popup.checkPaymentIcons());

        popup.closePopup();
    }
}