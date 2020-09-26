package com.pages;

import com.core.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchPage extends Base {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(linkText = "python/cpython")
    private WebElement firstResult;

    @FindBy(xpath = "//*[@id=\"readme\"]/div[2]/article/a[1]/img")
    private WebElement firstItemInStatusBar;


    public WebElement getFirstItemInStatusBar() {
        return firstItemInStatusBar;
    }
    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchField() {  return searchField; }
    public WebElement getFirstResult() {
        return firstResult;
    }


    public void searchForRepo(String repoName) {
       this.searchField.click();
        this.searchField.sendKeys(repoName);
        this.searchField.sendKeys(Keys.ENTER);

    }

    public void navigateToTheSearch() {

      this.firstResult.click();
    }

}