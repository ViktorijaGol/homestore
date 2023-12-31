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

    @FindBy(xpath = "(//ul[@class='products columns-4'])//li[2]//a[2]")
    WebElement addOneProductToCart;
    public void addProductToCart() { addOneProductToCart.click(); }

    @FindBy(css = "a[title='View cart']")
    WebElement viewCartButtonAppeared;
    public boolean viewCartButton() { return viewCartButtonAppeared.isDisplayed(); }
    public WebElement getElement() {
        return viewCartButtonAppeared;
    }
    public void clickNavigateToCart() { viewCartButtonAppeared.click(); }

    @FindBy(css = "a[title='View your shopping cart'] span[class='woocommerce-Price-amount amount']")
    WebElement totalSum;
    public String totalSumIsUpdated() { return totalSum.getText();
    }

    @FindBy(xpath = "(//ul[@class='products columns-4'])//li[2]//span[@class='price']")
    WebElement productPrice;
    public String productPrice() { return productPrice.getText();
    }

    @FindBy(xpath = "//span[text()='1 item']")
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

    @FindBy(xpath = "(//li[@class='woocommerce-mini-cart-item mini_cart_item'])[1]//a[2]")
    WebElement productTitleInCartBlock;
    public String productTitleVisible() { return productTitleInCartBlock.getText();
    }

    @FindBy(xpath = "(//ul[@class='products columns-4'])//li[2]//h2")
    WebElement productTitleShopPage;
    public String productTitleInTheShop() { return productTitleShopPage.getText();
    }
    public void clickOnProduct() { productTitleShopPage.click();
    }

    @FindBy(css = "ul[id='site-header-cart'] span[class='quantity']")
    WebElement productCountAndSumCartBlock;
    public String productAmountAndSumVisible() { return productCountAndSumCartBlock.getText();
    }

    @FindBy(xpath = "//ul[@id='site-header-cart']//p[@class=\"woocommerce-mini-cart__total total\"]//bdi[1]")
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
}
