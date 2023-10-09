package com.secretescapes.screens.components;

import com.secretescapes.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductComponent extends BaseScreen {

    private static final By TITLE = AppiumBy.id("com.secretescapes.mobile:id/title");
    private static final By PRICE_INFO = getByResourceId("com.secretescapes.mobile:id/priceInfo");
    private static final By DISCOUNT_BOX = getByResourceId("com.secretescapes.mobile:id/discountBox");

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getPriceInfo() {
        return driver.findElement(PRICE_INFO).getText();
    }

    public String getDiscountBox() {
        return driver.findElement(DISCOUNT_BOX).getText();
    }
}
