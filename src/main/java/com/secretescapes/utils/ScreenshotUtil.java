package com.secretescapes.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {

    @Attachment(value = "Final screenshot", type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverManager.get()).getScreenshotAs(OutputType.BYTES);
    }
}
