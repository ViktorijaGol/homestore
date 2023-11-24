import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) { super(driver); }

    @FindBy(css = "#username")
    WebElement usernameInput;
    public void fillEmail(String username) { usernameInput.sendKeys(username); }

    @FindBy(css = "#password")
    WebElement passwordInput;
    public void fillPassword(String password) { passwordInput.sendKeys(password); }

    @FindBy(css = "#rememberme")
    WebElement rememberMeCheck;
    public void checkRememberMe() { rememberMeCheck.click(); }

    @FindBy(css = "button[value='Log in']")
    WebElement loginButton;
    public void clickLogin() { loginButton.click(); }

    @FindBy(css = "ul[role='alert']")
    WebElement unknownEmailAlert;

    public String unknownEmailAdressError() { return unknownEmailAlert.getText(); }
}
