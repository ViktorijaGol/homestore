package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(css = "#site-header-cart")
    WebElement cartBlock;
    public void hoverCartBlock() {
        Actions hover = new Actions(driver);
        hover.moveToElement(cartBlock).perform();
    }

    public void clickCartBlock() { cartBlock.click();
    }

    @FindBy(css = "header[id='masthead'] " +
            "ul[class='woocommerce-mini-cart cart_list product_list_widget '] a:nth-child(2)")
    WebElement productTitleInCartBlock;
    public String productTitleVisible() { return productTitleInCartBlock.getText();
    }

    @FindBy(xpath = "//h2[normalize-space()='Classic TV stand']")
    WebElement productTitleShopPage;
    public String productTitleInTheShop() { return productTitleShopPage.getText();
    }

    @FindBy(css = "ul[id='site-header-cart'] span[class='quantity']")
    WebElement productCountAndSumCartBlock;
    public String productAmountAndSumVisible() { return productCountAndSumCartBlock.getText();
    }

    @FindBy(css = "ul[id='site-header-cart'] p[class='woocommerce-mini-cart__total total'] " +
            "span[class='woocommerce-Price-amount amount']")
    WebElement subtotalSum;
    public String subtotalSumIsVisible() { return subtotalSum.getText();
    }

    @FindBy(css = "ul[id='site-header-cart'] a[class='button wc-forward wp-element-button']")
    WebElement viewCartButtonInTheCartBlock;
    public boolean viewCartButtonIsVisible() { return viewCartButtonInTheCartBlock.isDisplayed();
    }

    @FindBy(css = "ul[id='site-header-cart'] a[class='button checkout wc-forward wp-element-button']")
    WebElement checkoutButtonInTheCartBlock;
    public boolean checkoutButtonIsVisible() { return checkoutButtonInTheCartBlock.isDisplayed();
    }

    @FindBy(css = "a[title='View cart']")
    WebElement viewCartButton;
    public void clickNavigateToCart() { viewCartButton.click(); }
}
