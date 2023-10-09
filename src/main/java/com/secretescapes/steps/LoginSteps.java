package com.secretescapes.steps;

import com.github.javafaker.Faker;
import com.secretescapes.screens.login.EmailLoginScreen;
import com.secretescapes.screens.login.LoginScreen;
import com.secretescapes.screens.login.NotificationsScreen;

public class LoginSteps {

    public static void loginWithRandomEmail() {
        new LoginScreen().tapContinueWithEmail();
        EmailLoginScreen emailLoginScreen = new EmailLoginScreen();
        emailLoginScreen.fillEmail(Faker.instance().internet().emailAddress());
        emailLoginScreen.tapContinue();
        new NotificationsScreen().tapRejectNotifications();
    }
}
