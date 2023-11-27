package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailedPage extends BasePage{
    public ProductDetailedPage(WebDriver driver) { super(driver); }


    @FindBy(css = ".product_title.entry-title")
    WebElement productDetailedPageTitle;
    public String productTitle() { return productDetailedPageTitle.getText();
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

    @FindBy(css = "div[class='quantity']")
    WebElement amountOfProductsNumber;
    public void chooseAmount() {
        amountOfProductsNumber.click();
    }
//    public void enterAmount() {
//        amountOfProductsNumber.clear();
//        amountOfProductsNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "14");
//    }
}
