package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) { super(driver); }

    @FindBy(css = "#username")
    WebElement usernameOrEmailInput;
    public void fillEmail(String email) { usernameOrEmailInput.sendKeys(email); }
    public void fillUsername(String username) { usernameOrEmailInput.sendKeys(username); }

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
    WebElement myAccountPageErrorAlert;
    public String unknownEmailAdressError() { return myAccountPageErrorAlert.getText(); }
    public String unknownUsernameError() { return myAccountPageErrorAlert.getText(); }
    public String usernameIsRequiredError() {  return myAccountPageErrorAlert.getText(); }
    public String passwordIsRequiredError() { return myAccountPageErrorAlert.getText(); }

    @FindBy(xpath = "//a[normalize-space()='Lost your password?']")
    WebElement lostYourPasswordLink;
    public void clickLostYourPassword() { lostYourPasswordLink.click(); }
}
