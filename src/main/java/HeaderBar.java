import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderBar extends BasePage{
    public HeaderBar(WebDriver driver) { super(driver); }

    @FindBy(css = "#menu-item-228")
    private WebElement myAccountLink;
    public void clickMyAccount() { myAccountLink.click(); }
}
