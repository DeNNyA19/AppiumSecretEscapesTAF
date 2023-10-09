package com.secretescapes;

import com.github.javafaker.Faker;
import com.secretescapes.screens.login.EmailLoginScreen;
import com.secretescapes.screens.login.LoginScreen;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {

    private static final String EXISTING_EMAIL = "zavijo@clout.wiki";

    @Test
    @DisplayName("Try to login with wrong password")
    public void wrongPassword() {
        new LoginScreen().tapContinueWithEmail();
        EmailLoginScreen emailLoginScreen = new EmailLoginScreen();
        emailLoginScreen.fillEmail(EXISTING_EMAIL);
        emailLoginScreen.fillPassword(Faker.instance().internet().password());
        assertThat(emailLoginScreen.getErrorMessage(), is(equalTo("Something has gone wrong with the application. Please try again.")));
    }

    /**
     * Bug in an application - no validation of wrong email format
     */
    @Test
    @DisplayName("Try to log in with invalid email")
    @Issue("Some issue id")
    public void invalidEmail() {
        new LoginScreen().tapContinueWithEmail();
        EmailLoginScreen emailLoginScreen = new EmailLoginScreen();
        emailLoginScreen.fillEmail(Faker.instance().internet().password());
        assertThat(emailLoginScreen.isContinueClickable(), is(false));
    }
}
