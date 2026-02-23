package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PaymentPopUpWindow {
    WebDriver driver;
    WebDriverWait wait;

    private By iframe = By.xpath("//div[@class='payment-widget-app']//iframe[contains(@src, 'checkout']");
    private By amountOnCard = By.xpath(
            "//div[@class='payment-page__order-description pay-description']//span[@class='ng-star-inserted']");
    private By amountOnButton = By.xpath(
            "//button[contains(@type, 'submit')]//span[contains(text(), 'Оплатить')]");
    private By phoneNumber = By.xpath("//div[@class='card-page__card']//div[@class='card-page__phone']");

    private By cardNumberField = By.id("cc-number");
    private By expiryDateField = By.id("cc-exp");
    private By cvvField = By.id("cc-csc");

    private By visaIcon = By.xpath("//img[contains(@src, 'visa-system.svg')]");
    private By mastercardIcon = By.xpath("//img[contains(@src, 'mastercard-system.svg')]");
    private By belkartIcon = By.xpath("//img[contains(@src, 'belkart-system.svg')]");
    private By mirIcon = By.xpath("//img[contains(@src, 'mir-system-ru.svg')]");
    private By maestroIcon = By.xpath("//img[contains(@src, 'maestro-system.svg')]");
}
