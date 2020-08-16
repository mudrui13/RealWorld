package tests;

import mainMethods.testMethods.TestCheckFilterByTagLogic;
import org.testng.annotations.*;

public class TestCheckFilterByTag {
    private TestCheckFilterByTagLogic filterByTagLogic;

    @BeforeClass
    public void setUp(){
        filterByTagLogic = new TestCheckFilterByTagLogic();
        filterByTagLogic.openPage();
    }

    @Test
    public void checkTagNameInTitle(){
        filterByTagLogic.checkTagInTitle();
    }

    @Test
    public void filterByTag(){
        //checkTagFilter parameter it's a count of pages to check (in out project maximum 50 pages)
        filterByTagLogic.checkTagFilter(1);
    }

    @AfterClass
    public void closeDriver(){
        filterByTagLogic.closeDriver();
    }
}
