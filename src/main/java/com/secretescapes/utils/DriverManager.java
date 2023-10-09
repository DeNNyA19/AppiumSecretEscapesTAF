package com.secretescapes.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setDriver() {
        DeviceType deviceType = DeviceType.getDeviceType();
        Map<String, Object> mapCapabilities = JsonFileReader.jsonToMap(deviceType.name().toLowerCase());
        mapCapabilities.entrySet().forEach(e -> {
            if (e.getKey().equals("app")) {
                e.setValue(new File(DriverManager.class.getClassLoader().getResource((String) e.getValue()).getFile()).getAbsolutePath());
            }
        });
        DesiredCapabilities capabilities = fromMapToDesiredCapabilities(mapCapabilities);
        URL driverUrl;
        try {
            driverUrl = new URL(Configuration.readProperty("driver.url"));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Issues with setting URL for driver", e);
        }
        switch (deviceType) {
            case ANDROID -> {
                driver.set(new AndroidDriver(driverUrl, capabilities));
            }
            case IOS -> {
                driver.set(new IOSDriver(driverUrl, capabilities));
            }
            default ->
                    throw new UnsupportedOperationException("Such device " + deviceType + " is not expected");
        }
    }

    public static void quit() {
        if (DriverManager.get() != null)  {
            DriverManager.get().quit();
        }
    }

    private static DesiredCapabilities fromMapToDesiredCapabilities(Map<String, Object> mapCapabilities) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        mapCapabilities.forEach(desiredCapabilities::setCapability);
        return desiredCapabilities;
    }

    public static AppiumDriverLocalService getAppiumService() {
        return new AppiumServiceBuilder()
                .withAppiumJS(new File(Configuration.readProperty("appium.path")))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
    }

    public static AppiumDriver get() {
        return driver.get();
    }

    private enum DeviceType {
        ANDROID,IOS;

        public static DeviceType getDeviceType() {
            try {
                return DeviceType.valueOf(Configuration.readProperty("platform.type").toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new UnsupportedOperationException("Such device " + Configuration.readProperty("platform.type") + " is not expected");
            }
        }
    }
}
