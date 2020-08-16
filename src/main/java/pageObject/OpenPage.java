package pageObject;

class OpenPage {
    void openPage(String url) {
        new Hooks();
        Hooks.driver.navigate().to(url);
    }
}
