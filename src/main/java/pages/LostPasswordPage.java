package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LostPasswordPage extends BasePage {
    public LostPasswordPage(WebDriver driver) { super(driver); }

    @FindBy(css = "#user_login")
    WebElement usernameOrEmailInput;
    public void fillUsernameEmailField(String usernameOrEmail) { usernameOrEmailInput.sendKeys(usernameOrEmail); }

    @FindBy(css = "ul[role='alert']")
    WebElement lostPasswordPageAlert;
    public String passwordRecoveryError() { return lostPasswordPageAlert.getText(); }


    @FindBy(css = "button[value='Reset password']")
    WebElement resetPasswordButton;
    public void clickResetPassword() { resetPasswordButton.click(); }
}
