package com.secretescapes.screens.login;

import com.secretescapes.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {

    private static final By LOGO = AppiumBy.id("com.secretescapes.mobile:id/logo");
    private static final By CONTINUE_WITH_EMAIL = AppiumBy.id("com.secretescapes.mobile:id/email");

    public LoginScreen() {
        waiter.waitForPresence(LOGO);
    }

    public void tapContinueWithEmail() {
        driver.findElement(CONTINUE_WITH_EMAIL).click();
    }
}
