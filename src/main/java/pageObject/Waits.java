package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

class Waits {

    void waitUntilVisible(By locator) {
        Hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void waitUntilInvisible(By locator){
        Hooks.wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


}
