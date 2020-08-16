package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

class Click {

    void clickButton(By ButtonLocator) {
        Hooks.driver.findElement(ButtonLocator).click();
    }

    void clickButtonByJS(String buttonLocator){
        JavascriptExecutor executor = (JavascriptExecutor) Hooks.driver;
        executor.executeScript("arguments[0].click();", Hooks.driver.findElement(By.xpath(buttonLocator)));
    }
}
