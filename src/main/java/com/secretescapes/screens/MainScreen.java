package com.secretescapes.screens;

import com.secretescapes.screens.components.DealsComponent;
import org.openqa.selenium.By;

public class MainScreen extends BaseScreen {

    private static final By TITLE = getByText("Browse all our holiday deals");
    private static final By VIEW_ALL_DEALS = scrollAndGetById("com.secretescapes.mobile:id/want_to_see_more");

    public MainScreen() {
        waiter.waitForPresence(TITLE);
    }

    public DealsComponent getDealsComponent() {
        return new DealsComponent();
    }

    public void tapViewAllDeals() {
        driver.findElement(VIEW_ALL_DEALS).click();
    }
}
