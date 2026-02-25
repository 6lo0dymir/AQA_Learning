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


    public void acceptCookies() {
        Allure.step("Принять куки");
        WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieBtn.click();
    }


    public String getBlockTitle() {
        Allure.step("Получить название блока оплаты");
        return driver.findElement(blockTitle).getText();
    }


    public boolean checkLogos() {
        Allure.step("Проверить логотипы платежных систем на главной странице оплаты");
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


    public void clickMoreAboutService() {
        Allure.step("Перейти по ссылке 'Подробнее о сервисе'");
        driver.findElement(moreAboutServiceLink).click();
    }


    public String getCurrentUrl() {
        Allure.step("Получить Url текущей страницы");
        return driver.getCurrentUrl();
    }


    public void selectPaymentOption(String optionText) {
        Allure.step("Выбрать опцию оплаты из выпадающего списка");

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

    public String getServicesPhonePlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Номер телефона'");
        return driver.findElement(servicesPhone).getAttribute("placeholder");
    }


    public String getServicesAmountPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Сумма'");
        return driver.findElement(servicesAmount).getAttribute("placeholder");
    }


    public String getServicesEmailPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Email'");
        return driver.findElement(servicesEmail).getAttribute("placeholder");
    }

    // "Домашний интернет"

    public String getInternetPhonePlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Номер телефона'");
        return driver.findElement(internetPhone).getAttribute("placeholder");
    }


    public String getInternetAmountPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Сумма'");
        return driver.findElement(internetAmount).getAttribute("placeholder");
    }


    public String getInternetEmailPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Email'");
        return driver.findElement(internetEmail).getAttribute("placeholder");
    }

    // "Рассрочка"

    public String getInstalmentPhonePlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Номер счета на 44'");
        return driver.findElement(instalmentScore).getAttribute("placeholder");
    }


    public String getInstalmentAmountPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Сумма'");
        return driver.findElement(instalmentAmount).getAttribute("placeholder");
    }


    public String getInstalmentEmailPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Email'");
        return driver.findElement(instalmentEmail).getAttribute("placeholder");
    }

    // "Задолженность"

    public String getArrearsPhonePlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Номер счета на 2073'");
        return driver.findElement(arrearsScore).getAttribute("placeholder");
    }


    public String getArrearsAmountPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Сумма'");
        return driver.findElement(arrearsAmount).getAttribute("placeholder");
    }


    public String getArrearsEmailPlaceholder() {
        Allure.step("Получить текст из плейсхолдера 'Email'");
        return driver.findElement(arrearsEmail).getAttribute("placeholder");
    }


    public void clickContinueButton()
    {
        Allure.step("Получить текст из плейсхолдера 'Продолжить'");
        driver.findElement(continueButton).click();
    }


    public void fillServicesForm(String phone, String amount, String email) {
        Allure.step("Ввести данные для оплаты");
        driver.findElement(By.id("connection-phone")).sendKeys(phone);
        driver.findElement(By.id("connection-sum")).sendKeys(amount);
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }
}

