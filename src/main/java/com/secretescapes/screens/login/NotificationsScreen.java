package com.secretescapes.screens.login;

import com.secretescapes.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NotificationsScreen extends BaseScreen {

    private static final By TITLE = getByText("New deals start and end every day");
    private static final By REJECT_NOTIFICATIONS = AppiumBy.id("com.secretescapes.mobile:id/rejectNotifications");

    public NotificationsScreen() {
        waiter.waitForPresence(TITLE);
    }

    public void tapRejectNotifications() {
        driver.findElement(REJECT_NOTIFICATIONS).click();
    }
}
