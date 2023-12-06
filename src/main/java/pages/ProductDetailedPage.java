package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailedPage extends BasePage{
    public ProductDetailedPage(WebDriver driver) { super(driver); }

    @FindBy(css = ".product_title.entry-title")
    WebElement productDetailedPageTitle;
    public boolean productTitle() { return productDetailedPageTitle.isDisplayed();
    }

    @FindBy(css = "p[class='price']")
    WebElement productPriceShown;
    public boolean productPriceVisible() { return productPriceShown.isDisplayed();
    }

    @FindBy(css = ".woocommerce-product-details__short-description")
    WebElement productDescriptionShown;
    public boolean productDescriptionVisible() { return productDescriptionShown.isDisplayed();
    }

    @FindBy(css = ".posted_in")
    WebElement productCategory;
    public boolean productCategoryVisible() { return productCategory.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='quantity']/input")
    WebElement amountOfProductsNumber;
    public void chooseAmount(String amountLarge) {
        amountOfProductsNumber.click();
        amountOfProductsNumber.clear();
        amountOfProductsNumber.sendKeys(amountLarge);
    }
    public void chooseAmountWithArrows() {
        amountOfProductsNumber.click();
        amountOfProductsNumber.sendKeys(Keys.ARROW_UP);
    }
    public void leaveAmountEmpty() {
        amountOfProductsNumber.click();
        amountOfProductsNumber.clear();
    }
    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement addToCartDetailed;
    public void addToCart() { addToCartDetailed.click();
    }

    @FindBy(css = "div[role='alert']")
    WebElement alert;
    public String addedToCartAssertVisible() { return alert.getText();
    }

    @FindBy(css = "div[role='alert'] a[class='button wc-forward wp-element-button']")
    WebElement viewCartButton;
    public boolean viewCartButtonAppears() { return viewCartButton.isDisplayed();
    }
}
