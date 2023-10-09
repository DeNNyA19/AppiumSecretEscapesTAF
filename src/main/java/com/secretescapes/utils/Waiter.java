package com.secretescapes.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Waiter {

    private final WebDriverWait wait;

    public Waiter(AppiumDriver driver) {
        long waitTime = Long.parseLong(Configuration.readProperty("waiting.default"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    public void waitForText(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void waitForTextToMatch(By locator, String pattern) {
        wait.until(ExpectedConditions.textMatches(locator, Pattern.compile(pattern)));
    }

    public void waitForTrue(Function<WebDriver, Boolean> isTrue) {
        wait.until(isTrue);
    }

    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
