package mainMethods.testMethods;

import mainMethods.locators.RealWorldLocators;
import mainMethods.projectMethods.ProjectMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.Hooks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCheckFilterByTagLogic extends ProjectMethods {
    private RealWorldLocators realWorldLocators;

    public TestCheckFilterByTagLogic() {
        realWorldLocators = new RealWorldLocators();
    }

    public void openPage() {
        openPage(RealWorldLocators.MAIN_URL);
        System.out.println(RealWorldLocators.MAIN_URL + "is opened");
        waitUntilVisible(RealWorldLocators.LOGO);
        System.out.println("The logo is present");
    }

    public void checkTagInTitle() {
        Set<String> errorTagTitle = new HashSet<>();
        // check all tags from Set Collection
        setTagsToCollection().forEach(tag -> {
            String tagLocator = String.format(RealWorldLocators.ONE_TAG, tag);
            System.out.println("The tag title: '" + tag + "' is checking now");
            clickButton(By.xpath(tagLocator));
            waitUntilInvisible(RealWorldLocators.LOADING_ARTICLES);
            if (!Hooks.driver.findElement(RealWorldLocators.TAG_TITLE).getText().equals(tag)) {
                errorTagTitle.add(tag);
            }
        });
        Assert.assertTrue(errorTagTitle.isEmpty(),
                String.format("!Error! Tags %s in title are displayed incorrectly after selecting tag", errorTagTitle));
    }

    public void checkTagFilter(int pagesFromTest) {
        realWorldLocators.setPagesCount(pagesFromTest);
        Set<String> errorTags = new HashSet<>();
        // check all tags from Set Collection
        setTagsToCollection().forEach(tag -> {
            String tagLocator = String.format(RealWorldLocators.ONE_TAG, tag);
            System.out.println("The tag: '" + tag + "' is checking now");
            clickButton(By.xpath(tagLocator));
            waitUntilInvisible(RealWorldLocators.LOADING_ARTICLES);

            // check tag on pages with count from test class
            for (int i = 1; i <= realWorldLocators.getPagesCount(); i++) {
                AtomicInteger temp = new AtomicInteger();
                List<WebElement> articles = Hooks.driver.findElements(RealWorldLocators.ARTICLES_LIST);

                // main check: check the selected tag is present on article right bottom
                articles.forEach(articlesCount -> {
                    temp.getAndIncrement();
                    if (!checkTagInArticle(temp.get(), tag)) {
                        String href = getHrefFromElement(temp.get());
                        errorTags.add(tag + " on href: " + href);
                    }
                });
                // click next page if needed
                if (i < realWorldLocators.getPagesCount()) {
                    clickNextPage(i + 1);
                    waitUntilInvisible(RealWorldLocators.LOADING_ARTICLES);
                }
            }
        });
        Assert.assertTrue(errorTags.isEmpty(),
                String.format("!Error! Filter functionality are not working correctly with %s", errorTags));
    }

    public void closeDriver() {
        super.closeDriver();
    }
}
