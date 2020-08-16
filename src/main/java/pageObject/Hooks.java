package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {

    public static WebDriver driver ;
    static WebDriverWait wait;

    static {
        driver = CustomWebDriver.getDriver();

        if (wait == null){
            wait = new WebDriverWait(driver, 2);
        }
    }
}
