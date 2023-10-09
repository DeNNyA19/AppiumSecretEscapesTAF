package com.secretescapes.screens.components;

import com.secretescapes.enums.Deal;
import com.secretescapes.screens.BaseScreen;
import io.appium.java_client.AppiumBy;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DealsComponent extends BaseScreen {

    private static final By LOCATOR = AppiumBy.id("com.secretescapes.mobile:id/productCategoriesRecycler");

    public void chooseDeal(Deal deal) {
        chooseDeal(deal.getDeal());
    }

    public void chooseDeal(String deal) {
        driver.findElement(getByText(deal)).click();
    }

    public String getRandomDeal() {
        List<WebElement> deals = driver.findElement(LOCATOR).findElements(AppiumBy.className("android.widget.TextView"));
        WebElement randomDeal = deals.get(RandomUtils.nextInt(0, deals.size() - 1));
        return randomDeal.getText();
    }
}
