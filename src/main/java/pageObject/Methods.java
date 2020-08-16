package pageObject;

import org.openqa.selenium.By;

public class Methods {

    protected void openPage(String url) {
        new OpenPage().openPage(url);
    }

    protected void waitUntilVisible(By locator){
        new Waits().waitUntilVisible(locator);
    }

    protected void waitUntilInvisible(By locator){
        new Waits().waitUntilInvisible(locator);
    }

    public void closeDriver(){
        new CloseDriver().closeDriver();
    }

    protected void clickButton(By locator){
        new Click().clickButton(locator);
    }

    protected void clickButtonByJS(String locator){
        new Click().clickButtonByJS(locator);
    }


}
