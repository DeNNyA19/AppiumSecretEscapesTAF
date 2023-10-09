package com.secretescapes;

import com.secretescapes.utils.Configuration;
import com.secretescapes.utils.DriverManager;
import com.secretescapes.utils.ScreenshotExtension;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ScreenshotExtension.class)
public class BaseTest {

    private static AppiumDriverLocalService appiumService;

    @BeforeAll
    public static void runAppiumService() {
        if (!Configuration.readProperty("appium.path").isEmpty()) {
            appiumService = DriverManager.getAppiumService();
            appiumService.start();
        }
    }

    @BeforeEach
    public void openApp() {
        DriverManager.setDriver();
    }

    @AfterEach
    public void closeApp() {
        if (DriverManager.get() != null) {
            DriverManager.quit();
        }
    }

    @AfterAll
    public static void closeAppiumService() {
        if (!Configuration.readProperty("appium.path").isEmpty()) {
            appiumService.stop();
        }
    }
}
