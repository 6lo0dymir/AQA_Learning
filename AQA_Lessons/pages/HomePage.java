package pages;


import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By blockTitle = By.xpath("//div[contains(@class, 'pay')]//h2");
    private By cookieButton = By.xpath("//button[contains(text(), 'Принять')]");
    private By moreAboutServiceLink = By.linkText("Подробнее о сервисе");

    private By visaLogo = By.xpath("//img[contains(@src, 'visa.svg') and contains(@src, 'pay')]");
    private By visaVerifiedLogo = By.xpath("//img[contains(@src, 'visa-verified.svg')]");
    private By mastercardLogo = By.xpath("//img[contains(@src, 'mastercard.svg') and contains(@src, 'pay')]");
    private By mastercardSecureLogo = By.xpath("//img[contains(@src, 'mastercard-secure.svg') ]");
    private By belkartLogo = By.xpath("//img[contains(@src, 'belkart.svg') and contains(@src, 'pay')]");

    private By paymentTypeDropdown = By.xpath("//button[@class='select__header']");
    private By paymentOptions = By.xpath("//p[@class='select__option']");
    // "Услуги связи"
    private By servicesPhone = By.id("connection-phone");
    private By servicesAmount = By.id("connection-sum");
    private By servicesEmail = By.id("connection-email");

    // "Домашний интернет"
    private By internetPhone = By.id("internet-phone");
    private By internetAmount = By.id("internet-sum");
    private By internetEmail = By.id("internet-email");

    // "Рассрочка"
    private By instalmentScore = By.id("score-instalment");
    private By instalmentAmount = By.id("instalment-sum");
    private By instalmentEmail = By.id("instalment-email");

    // "Задолженность"
    private By arrearsScore = By.id("score-arrears");
    private By arrearsAmount = By.id("arrears-sum");
    private By arrearsEmail = By.id("arrears-email");

    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Принять куки")
    public void acceptCookies() {
        WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieBtn.click();
    }

    @Step("Получить заголовок блока")
    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

    @Step("Проверить отображение всех логотипов")
    public boolean checkLogos() {
        try {
            driver.findElement(visaLogo).isDisplayed();
            driver.findElement(visaVerifiedLogo).isDisplayed();
            driver.findElement(mastercardLogo).isDisplayed();
            driver.findElement(mastercardSecureLogo).isDisplayed();
            driver.findElement(belkartLogo).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Кликнуть на ссылку 'Подробнее о сервисе'")
    public void clickMoreAboutService() {
        driver.findElement(moreAboutServiceLink).click();
    }

    @Step("Получить текущий URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Выбрать опцию оплаты: {optionText}")
    public void selectPaymentOption(String optionText) {

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(paymentTypeDropdown));
        dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentOptions));

        var options = driver.findElements(paymentOptions);

        for (var option : options) {
            if (option.getText().contains(optionText)) {
                option.click();
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // "Услуги связи"
    @Step("Получить плейсхолдер телефона")
    public String getServicesPhonePlaceholder() {
        return driver.findElement(servicesPhone).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер суммы")
    public String getServicesAmountPlaceholder() {
        return driver.findElement(servicesAmount).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер Email")
    public String getServicesEmailPlaceholder() {
        return driver.findElement(servicesEmail).getAttribute("placeholder");
    }

    // "Домашний интернет"
    @Step("Получить плейсхолдер поля 'телефон'")
    public String getInternetPhonePlaceholder() {
        return driver.findElement(internetPhone).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер поля 'сумма'")
    public String getInternetAmountPlaceholder() {
        return driver.findElement(internetAmount).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер поля 'Email'")
    public String getInternetEmailPlaceholder() {
        return driver.findElement(internetEmail).getAttribute("placeholder");
    }

    // "Рассрочка"
    @Step("Получить плейсхолдер поля 'Номер счета'")
    public String getInstalmentPhonePlaceholder() {
        return driver.findElement(instalmentScore).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер поля 'сумма'")
    public String getInstalmentAmountPlaceholder() {
        return driver.findElement(instalmentAmount).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер поля 'Email'")
    public String getInstalmentEmailPlaceholder() {
        return driver.findElement(instalmentEmail).getAttribute("placeholder");
    }

    // "Задолженность"
    @Step("Получить плейсхолдер поля 'Номер счета'")
    public String getArrearsPhonePlaceholder() {
        return driver.findElement(arrearsScore).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер поля 'сумма'")
    public String getArrearsAmountPlaceholder() {
        return driver.findElement(arrearsAmount).getAttribute("placeholder");
    }

    @Step("Получить плейсхолдер поля 'Email'")
    public String getArrearsEmailPlaceholder() {
        return driver.findElement(arrearsEmail).getAttribute("placeholder");
    }

    @Step("Кликнуть на кнопку 'продолжить'")
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    @Step("Заполнить форму оплаты: телефон {0}, сумма {1}, email {2}")
    public void fillServicesForm(String phone, String amount, String email) {
        driver.findElement(By.id("connection-phone")).sendKeys(phone);
        driver.findElement(By.id("connection-sum")).sendKeys(amount);
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }
}

