package mainMethods.projectMethods;

import mainMethods.locators.RealWorldLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import pageObject.Hooks;
import pageObject.Methods;

import java.util.Set;
import java.util.stream.Collectors;

public class ProjectMethods extends Methods {

    protected Set<String> setTagsToCollection(){
        return Hooks.driver.findElements(RealWorldLocators.TAGS)
                .stream()
                .map(WebElement::getText)
                .map(s -> s.replaceAll("[\\u200C]", ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());
    }

    protected boolean checkTagInArticle(int index, String name){
        String articleTagLocator = String.format(RealWorldLocators.ARTICLE_TAG_PATH, index, name);
        try{
            Hooks.driver.findElement(By.xpath(articleTagLocator)).isDisplayed();
            return true;
        } catch (WebDriverException e){
            return false;
        }
    }

    protected void clickNextPage(int index){
        String nextPage = String.format(RealWorldLocators.ONE_PAGE, index);
        waitUntilVisible(By.xpath(nextPage));
        clickButtonByJS(nextPage);
    }

    protected String getHrefFromElement(int index){
        String hrefLocator = String.format(RealWorldLocators.HREF_LINK, index);
        return Hooks.driver.findElement(By.xpath(hrefLocator)).getAttribute("href");
    }
}
