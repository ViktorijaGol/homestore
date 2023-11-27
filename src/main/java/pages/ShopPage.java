package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage{
    public ShopPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//a[@class='next page-numbers']")
    WebElement forwardPageArrow;
    public void clickArrowForward() { forwardPageArrow.click(); }

    @FindBy(xpath = "//a[@class='prev page-numbers']")
    WebElement previousPageArrow;
    public void clickArrowBack() { previousPageArrow.click(); }

    @FindBy(xpath = "//span[@class='page-numbers current']")
    WebElement currentPage;
    public String redirectedTo() { return currentPage.getText(); }

    @FindBy(xpath = "//a[@class='page-numbers']")
    WebElement pageNumber;
    public void clickPageNumber() { pageNumber.click(); }

    @FindBy(css = ".woocommerce-info.woocommerce-no-products-found")
    WebElement noProductsFoundAlert;
    public String noProductsWereFound() { return noProductsFoundAlert.getText(); }

    @FindBy(css = ".woocommerce-products-header")
    WebElement productsFoundHeader;
    public String searchResults() { return productsFoundHeader.getText(); }

    @FindBy(xpath = "//p[@class='woocommerce-result-count']")
    WebElement resultCountParagraph;
    public String resultsCount() { return resultCountParagraph.getText(); }

    @FindBy(css = "a[aria-label='Add “Classic TV stand” to your cart']")
    WebElement addTvStandToCart;
    public void addProductToCart() { addTvStandToCart.click(); }

    @FindBy(css = "a[title='View cart']")
    WebElement viewCartButtonAppeared;
    public boolean viewCartButton() { return viewCartButtonAppeared.isDisplayed();
    }

    public WebElement getElement() {
        return viewCartButtonAppeared;
    }

    @FindBy(css = "a[title='View your shopping cart'] span[class='woocommerce-Price-amount amount']")
    WebElement totalSum;
    public String totalSumIsUpdated() { return totalSum.getText();
    }

    @FindBy(xpath = "//a[@href='https://themes.woocommerce.com/homestore/product/classic-tv-stand/']" +
            "//span[@class='price']//span[@class='woocommerce-Price-amount amount']")
    WebElement productPrice;
    public String productPrice() { return productPrice.getText();
    }

    @FindBy(xpath = "//span[normalize-space()='1 item']")
    WebElement itemsInTheCart;
    public String itemAmountUpdated() { return  itemsInTheCart.getText();
    }
}
