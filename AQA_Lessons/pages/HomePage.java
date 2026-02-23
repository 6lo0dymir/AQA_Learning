package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By blockTitle = By.xpath("//div[contains(@class, 'pay')]//h2");
    private By cookieButton = By.xpath("//button[contains(text(), 'Принять')]");
    private By moreAboutServiceLink = By.linkText("Подробнее о сервисе");

    private By visaLogo = By.xpath("//img[contains(@src, 'visa.svg') and contains(@alt, 'Visa')]");
    private By visaVerifiedLogo = By.xpath("//img[contains(@src, 'visa-verified.svg')]");
    private By mastercardLogo = By.xpath("//img[contains(@src, 'mastercard.svg')]");
    private By mastercardSecureLogo = By.xpath("//img[contains(@src, 'mastercard-secure.svg')]");
    private By belkartLogo = By.xpath("//img[contains(@src, 'belkart.svg')]");

    private By paymentTypeDropdown = By.xpath("//div[@class='select__header']");
    private By paymentOptions = By.xpath("//div[@class='select__option']");
    private By phoneField = By.id("connection-phone");
    private By amountField = By.id("connection-sum");
    private By emailField = By.id("connection-email");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookies() {
        WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieBtn.click();
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText();
    }

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

    public void clickMoreAboutService() {
        driver.findElement(moreAboutServiceLink).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void selectPaymentOption(String optionText) {
        driver.findElement(paymentTypeDropdown).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ищем нужную опцию и кликаем
        var options = driver.findElements(paymentOptions);
        for (var option : options) {
            if (option.getText().contains(optionText)) {
                option.click();
                break;
            }
        }

    }

    public String getPhonePlaceholder() {
        return driver.findElement(phoneField).getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return driver.findElement(amountField).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(emailField).getAttribute("placeholder");
    }

    public void fillPhoneForm(String phone, String amount, String email) {
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(amountField).sendKeys(amount);
        if (email != null && !email.isEmpty()) {
            driver.findElement(emailField).sendKeys(email);
        }
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}

