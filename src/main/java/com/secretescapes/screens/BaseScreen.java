package com.secretescapes.screens;

import com.secretescapes.utils.DriverManager;
import com.secretescapes.utils.Waiter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public abstract class BaseScreen {

    protected Waiter waiter = new Waiter(DriverManager.get());
    protected AppiumDriver driver = DriverManager.get();

    protected static By getByText(String text) {
        return AppiumBy.androidUIAutomator("text(\"%s\")".formatted(text));
    }

    protected static By getByResourceId(String resourceId) {
        return AppiumBy.androidUIAutomator("resourceId(\"%s\")".formatted(resourceId));
    }

    protected static By scrollAndGetById(String id) {
        return AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"%s\"))".formatted(id));
    }
}
