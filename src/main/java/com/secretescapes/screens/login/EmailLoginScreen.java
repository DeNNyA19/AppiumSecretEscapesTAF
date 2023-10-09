package com.secretescapes.screens.login;

import com.secretescapes.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class EmailLoginScreen extends BaseScreen {

    private static final By EMAIL_FIELD = AppiumBy.id("com.secretescapes.mobile:id/email");
    private static final By PASSWORD_FIELD = AppiumBy.id("com.secretescapes.mobile:id/password");
    private static final By CONTINUE_BTN = AppiumBy.id("com.secretescapes.mobile:id/continue_cta");
    private static final By ERROR_MESSAGE = AppiumBy.id("android:id/message");

    public EmailLoginScreen() {
        waiter.waitForPresence(EMAIL_FIELD);
    }

    public void fillEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public boolean isContinueClickable() {
        return Boolean.parseBoolean(driver.findElement(CONTINUE_BTN).getAttribute("clickable"));
    }

    public void tapContinue() {
        driver.findElement(CONTINUE_BTN).click();
    }

    public void fillPassword(String password) {
        tapContinue();
        waiter.waitForPresence(PASSWORD_FIELD);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        tapContinue();
    }

    public String getErrorMessage() {
        waiter.waitForPresence(ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
