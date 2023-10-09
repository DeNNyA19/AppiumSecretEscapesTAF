package com.secretescapes.steps;

import com.secretescapes.screens.DealsScreen;
import com.secretescapes.screens.MainScreen;

public class BrowseSteps {

    public static String chooseRandomDeal() {
        MainScreen mainScreen = new MainScreen();
        String randomDeal = mainScreen.getDealsComponent().getRandomDeal();
        mainScreen.getDealsComponent().chooseDeal(randomDeal);
        DealsScreen dealsScreen = new DealsScreen(randomDeal);
        randomDeal = dealsScreen.getRandomDeal();

        dealsScreen.chooseRandomDeal(randomDeal);
        return randomDeal;
    }
}
