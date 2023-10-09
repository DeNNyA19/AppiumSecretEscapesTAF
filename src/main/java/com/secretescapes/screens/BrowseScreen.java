package com.secretescapes.screens;

import com.secretescapes.screens.components.ProductComponent;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class BrowseScreen extends BaseScreen {

    private static final By TITLE = AppiumBy.id("com.secretescapes.mobile:id/toolbar_title");

    public BrowseScreen(String name) {
        waiter.waitForTextToMatch(TITLE, getTitlePattern(name));
    }

    public BrowseScreen(String name, int expectedCount) {
        waiter.waitForTextToMatch(TITLE, getTitlePattern(name, expectedCount));
    }

    public ProductComponent getFirstProduct() {
        return new ProductComponent();
    }

    /*
        Expects title with deal name and number higher than 0
     */
    private String getTitlePattern(String name) {
        return "%s \\([1-9]\\d*\\)".formatted(name);
    }

    /*
        Expects title with deal name and specific number
     */
    private String getTitlePattern(String name, int count) {
        return "%s \\(%d\\)".formatted(name, count);
    }
}
