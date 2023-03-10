package com.solvd.posteducationtasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(css = "[data-nav-ref='nav_ya_signin']")
    private WebElement signInButton;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement userNameButton;

    @FindBy(css = "#nav-cart")
    private WebElement shoppingCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage openResultPage(String searchText) {
        sendKeys(searchBar, searchText);
        clickButton(searchButton);
        return new SearchResultPage(driver);
    }

    public SignInPage clickSignInButton() {
        clickButton(signInButton);
        return new SignInPage(driver);
    }

    public String getUserName() {
        String userName = userNameButton.getText();
        String[] array = userName.split(" ");
        userName = array[1];
        return userName;
    }

    public ShoppingCartPage clickShoppingCartButton() {
        clickButton(shoppingCartButton);
        return new ShoppingCartPage(driver);
    }
}
