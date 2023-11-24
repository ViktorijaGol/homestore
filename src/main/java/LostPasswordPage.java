import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LostPasswordPage extends BasePage{
    public LostPasswordPage(WebDriver driver) { super(driver); }

    @FindBy(css = "#user_login")
    WebElement usernameOrEmailInput;
    public void fillUsername(String username) { usernameOrEmailInput.sendKeys(username); }
    public void fillEmail(String email) { usernameOrEmailInput.sendKeys(email); }
}
