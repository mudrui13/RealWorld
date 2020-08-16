package mainMethods.locators;

import org.openqa.selenium.By;

import static org.testng.Assert.fail;

public class RealWorldLocators {
    public static final String MAIN_URL = "https://demo.realworld.io";
    public static final String TAGS_LIST = "//div[@class='tag-list']";
    public static final String ELEMENT_PATH_BY_TEXT = "//*[text()=\"%s\"]";
    public static final String ONE_TAG = TAGS_LIST + ELEMENT_PATH_BY_TEXT;
    public static final String ARTICLE_TAG_PATH = "//article-list[@class='ng-isolate-scope']//article-preview[%s]" +
            "//*[@class='tag-list']//*[starts-with(normalize-space(text()),\"%s\")]";
    public static final String ONE_PAGE = "//ul[@class='pagination']//a[text()=\"%s\"]";
    public static final String HREF_LINK = "//article-list[@class='ng-isolate-scope']//article-preview[%s]" +
            "//*[@class='preview-link']";

    public static final By TAG_TITLE = By.xpath("//a[@class='nav-link active ng-binding']");
    public static final By TAGS = By.xpath(TAGS_LIST + "/a");
    public static final By ARTICLES_LIST = By.xpath("//article-list[@class='ng-isolate-scope']//*[@class='article-meta']/a");
    public static final By LOADING_ARTICLES = By.xpath("//p[contains(text(),'Loading articles...')]");
    public static final By LOGO = By.xpath("//h1[@class='logo-font ng-binding']");

    private int pagesCount;
    public int getPagesCount() {
        return pagesCount;
    }
    public void setPagesCount(int pagesCount) {
        if (pagesCount <= 50)
            this.pagesCount = pagesCount;
        else
            fail("The maximum count of pages are 50");
    }

}
