package bars;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HeaderBar extends BasePage {
    public HeaderBar(WebDriver driver) { super(driver); }

    @FindBy(css = "#menu-item-228")
    WebElement myAccountLink;
    public void clickMyAccount() { myAccountLink.click(); }

    @FindBy(css = "#woocommerce-product-search-field-0")
    WebElement searchBarTop;
    public void typeExistingProductName(String existingProductName) {
        searchBarTop.sendKeys(existingProductName, Keys.ENTER);
    }
    public void typeNonExistingProductName(String nonExistingProductName) {
        searchBarTop.sendKeys(nonExistingProductName, Keys.ENTER);
    }
}
