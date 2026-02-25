package pages;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class PaymentPopUpWindow {
    WebDriver driver;
    WebDriverWait wait;

    private By amountOnCard = By.xpath(
            "//div[@class='payment-page__order-description pay-description']//span[@class='ng-star-inserted']");
    private By amountOnButton = By.xpath(
            "//button[contains(@type, 'submit')]//span[contains(text(), 'Оплатить')]");
    private By phoneNumber = By.xpath("//div[@class='pay-description__text']//span[contains(text(), 'Номер')]");

    private By cardNumberLabel = By.xpath("//label[text()='Номер карты']");
    private By expiryDateLabel = By.xpath("//label[contains(text(), 'Срок действия')]");
    private By cvcLabel = By.xpath("//label[contains(text(), 'CVC')]");

    private By visaIcon = By.xpath("//img[contains(@src, 'visa-system.svg')]");
    private By mastercardIcon = By.xpath("//img[contains(@src, 'mastercard-system.svg')]");
    private By belkartIcon = By.xpath("//img[contains(@src, 'belkart-system.svg')]");
    private By mirIcon = By.xpath("//img[contains(@src, 'mir-system-ru.svg')]");
    private By maestroIcon = By.xpath("//img[contains(@src, 'maestro-system.svg')]");

    public PaymentPopUpWindow(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Переключение в iframe платежного виджета")
    private void switchToIframe() {
        try {
            Thread.sleep(3000);
            driver.switchTo().defaultContent();

            driver.switchTo().frame(driver.findElement(By.className("payment-widget-iframe")));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при переключении на фрейм: " + e.getMessage());
        }
    }
    @Step("Получение суммы на карте")
    public String getAmountOnCard() {
        switchToIframe();
        return driver.findElement(amountOnCard).getText();
    }
    @Step("Получение суммы на кнопке")
    public String getAmountOnButton() {

        return driver.findElement(amountOnButton).getText();
    }
    @Step("Получение номера телефона")
    public String getPhoneNumber() {

        return driver.findElement(phoneNumber).getText();
    }
    @Step("Получение текста плейсхолдера из поля 'номер карты'")
    public String getCardNumberLabelText() {
        switchToIframe();
        return driver.findElement(cardNumberLabel).getText();
    }
    @Step("Получение текста плейсхолдера из поля 'срок действия'")
    public String getExpiryDateLabelText() {
        switchToIframe();
        return driver.findElement(expiryDateLabel).getText();
    }
    @Step("Получение текста плейсхолдера из поля ''")
    public String getCvcLabelText() {
        switchToIframe();
        return driver.findElement(cvcLabel).getText();
    }
    @Step("Проверка иконок способов оплаты")
    public boolean checkPaymentIcons() {
        try {
            driver.findElement(visaIcon).isDisplayed();
            driver.findElement(mastercardIcon).isDisplayed();
            driver.findElement(belkartIcon).isDisplayed();
            driver.findElement(mirIcon).isDisplayed();
            driver.findElement(maestroIcon).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closePopup() {
        driver.switchTo().defaultContent();
    }
}

