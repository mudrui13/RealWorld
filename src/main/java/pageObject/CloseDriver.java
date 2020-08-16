package pageObject;

class CloseDriver {
    void closeDriver() {
        if (Hooks.driver != null) {
            Hooks.driver.quit();
        }
    }
}
