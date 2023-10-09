# AppiumSecretEscapesTAF

## Technologies used:
- Java 17
- Appium 2
- JUnit 5
- Allure

## Before running the tests following steps should be performed/verified:
- Java 17 and Appium 2 are installed
  - To install and configure appium for run on Android perform following steps:
    - `npm i --location=global appium`
    - `appium driver install uiautomator2`
- Appium server is running
  - You can do this by running `appium` in the terminal
  - If you want the server to run/shutdown automatically before/after the tests add path to the appium executable from your local machine to the _config.properties_ `appium.path` variable, otherwise leave empty
- Android device is available through ADB (e.g. could be run in Android Studio Emulator)
- Device name is set in the _android.json_ property `deviceName`

## How to run the tests

Simply execute `mvn clean test`

In order to generate allure report run `allure serve` in the terminal. For demo purposes there are existing test results with one failure from the latest run.