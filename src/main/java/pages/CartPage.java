package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//h1[normalize-space()='Cart']")
    WebElement cartPage;
    public boolean cartDisplayed() { return cartPage.isDisplayed();
    }
}
