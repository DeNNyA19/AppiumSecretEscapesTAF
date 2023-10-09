package com.secretescapes.screens;

import io.appium.java_client.AppiumBy;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DealsScreen extends BaseScreen {

    private static final By DEALS_LIST = getByResourceId("com.secretescapes.mobile:id/subcategoriesRecyclerview");

    private static final By TITLE = AppiumBy.id("com.secretescapes.mobile:id/toolbar_title");

    public DealsScreen(String name) {
        waiter.waitForText(TITLE, name);
    }

    public void chooseRandomDeal(String dealName) {
        driver.findElement(getByText(dealName)).click();
    }

    public String getRandomDeal() {
        List<WebElement> deals = driver.findElement(DEALS_LIST).findElements(AppiumBy.className("android.widget.TextView"));
        WebElement randomDeal = deals.get(RandomUtils.nextInt(0, deals.size() - 1));
        return randomDeal.getText();
    }
}
