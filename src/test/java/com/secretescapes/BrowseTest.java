package com.secretescapes;

import com.secretescapes.screens.BrowseScreen;
import com.secretescapes.screens.DealsScreen;
import com.secretescapes.screens.MainScreen;
import com.secretescapes.screens.components.ProductComponent;
import com.secretescapes.steps.LoginSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BrowseTest extends BaseTest {

    @Test
    @DisplayName("Proceed to Browse screen through the top suggestions")
    public void proceedToBrowseThroughSuggestions() {
        LoginSteps.loginWithRandomEmail();

        MainScreen mainScreen = new MainScreen();
        String randomDeal = mainScreen.getDealsComponent().getRandomDeal();
        mainScreen.getDealsComponent().chooseDeal(randomDeal);
        DealsScreen dealsScreen = new DealsScreen(randomDeal);
        randomDeal = dealsScreen.getRandomDeal();

        dealsScreen.chooseRandomDeal(randomDeal);
        BrowseScreen browseScreen = new BrowseScreen(randomDeal);
        ProductComponent productComponent = browseScreen.getFirstProduct();
        assertThat(productComponent.getTitle(), not(emptyOrNullString()));
        assertThat(productComponent.getPriceInfo(), not(emptyOrNullString()));
    }

    @Test
    @DisplayName("Proceed to Browse screen bottom View all button")
    public void proceedToBrowseThroughViewAll() {
        LoginSteps.loginWithRandomEmail();

        MainScreen mainScreen = new MainScreen();
        mainScreen.tapViewAllDeals();
        BrowseScreen browseScreen = new BrowseScreen("Results");
        ProductComponent productComponent = browseScreen.getFirstProduct();
        assertThat(productComponent.getTitle(), not(emptyOrNullString()));
        assertThat(productComponent.getPriceInfo(), not(emptyOrNullString()));
    }
}
