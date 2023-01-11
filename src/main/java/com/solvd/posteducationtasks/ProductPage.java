package com.solvd.posteducationtasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='selectQuantity']/../../..//*[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(css = "[aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    private WebElement cartButton;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage addToCart() {
        addToCartButton.click();
        cartButton.click();
        return new ShoppingCartPage();
    }
}
