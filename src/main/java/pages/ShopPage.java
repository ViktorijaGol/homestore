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
}
