package com.examples;
import com.core.Base;
import com.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends Base {

    @Test(priority = 1, description = "this test case is for verify that the search field have valid place holder ")

    public void VerifyPlaceHolderOfSearchField(){

     SearchPage searchPage =new SearchPage(driver);

     String actualPlaceHolder= searchPage.getSearchField().getAttribute("placeholder");
     String expectedPlaceHolde= "Search GitHub";
     Assert.assertEquals(actualPlaceHolder,expectedPlaceHolde);

    }
    @Test(priority = 2, description = "this test case is for search for the specific repository ")

    public void searchTestForRepo()  {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchForRepo("python/cpython");

       Assert.assertTrue(searchPage.getFirstResult().isDisplayed());
    }

    @Test(priority = 3, description = "this test case is for navigate to the first result ")
    public void navigateToSearchTerms(){
      String expectedURL ="https://github.com/python/cpython";

        SearchPage searchPage = new SearchPage(driver);
        searchPage.navigateToTheSearch();
      Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
      Assert.assertTrue(searchPage.getFirstItemInStatusBar().isDisplayed());


    }


}