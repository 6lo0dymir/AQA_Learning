import io.github.bonigarcia.wdm.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import javax.lang.model.element.*;
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MtsByTests {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.mts.by");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока")
    public void testBlockName() {
        WebElement titleElement = driver.findElement(
                By.xpath("//div[contains(@class, 'pay')]//h2")
        );
        String blockTitle = titleElement.getText();
        assertTrue(blockTitle.contains("Онлайн пополнение") || blockTitle.contains("без комиссии"));
    }

    @Test
    @Order(2)
    @DisplayName("Проверка логотипов платежных систем")
    public void testPaymentSystemLogo() {
        WebElement logoVisa = driver.findElement(
                By.xpath("//img[contains(@src, 'visa.svg')]")
        );
        WebElement logoVerifiedByVisa = driver.findElement(
                By.xpath("//img[contains(@src, 'visa-verified.svg')]")
        );
        WebElement logoMasterCard = driver.findElement(
                By.xpath("//img[contains(@src, 'mastercard.svg')]")
        );
        WebElement logoMasterCardSecureCode = driver.findElement(
                By.xpath("//img[contains(@src, 'mastercard-secure.svg')]")
        );
        WebElement logoBelkart = driver.findElement(
                By.xpath("//img[contains(@src, 'belkart.svg')]")
        );
    }

    @Test
    @Order(3)
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    public void testMoreAboutServiceLink() {
        String initialUrl = driver.getCurrentUrl();
        WebElement cookieButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]"))
        );
        cookieButton.click();
        WebElement moreAboutServiceLink = driver.findElement(
                By.linkText("Подробнее о сервисе")
        );
        moreAboutServiceLink.click();
        String moreAboutServiceUrl = driver.getCurrentUrl();
        assertNotEquals(initialUrl, moreAboutServiceUrl, "Url не изменился");

    }

    @Test
    @Order(4)
    @DisplayName("Проверка ссылки 'Проверка полей и кнопки 'Продолжить''")
    public void testPaymentForm() {
        String phoneNumber = "297777777";
        String payAmount = "100.00";
        WebElement cookieButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]"))
        );
        cookieButton.click();
        WebElement phoneNumberField = driver.findElement(
                By.id("connection-phone")
        );
        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);

        WebElement payAmountField = driver.findElement(
                By.id("connection-sum")
        );
        payAmountField.click();
        payAmountField.sendKeys(payAmount);

        WebElement buttonSubmit = driver.findElement(
                By.xpath("//button[contains(text(), 'Продолжить')]")
        );
        buttonSubmit.click();

    }
}
