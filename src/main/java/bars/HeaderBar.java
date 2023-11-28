package bars;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HeaderBar extends BasePage {
    public HeaderBar(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//a[text()='My Account']")
    WebElement myAccountLink;
    public void clickMyAccount() { myAccountLink.click(); }

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchBarTop;
    public void typeExistingProductName(String existingProductName) {
        searchBarTop.sendKeys(existingProductName, Keys.ENTER);
    }
    public void typeNonExistingProductName(String nonExistingProductName) {
        searchBarTop.sendKeys(nonExistingProductName, Keys.ENTER);
    }
    public void clickSearchWhenLeftEmpty() { searchBarTop.sendKeys(Keys.ENTER);
    }
}
