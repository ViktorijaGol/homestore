package loginTest;

import bars.HeaderBar;
import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.*;

public class UnsuccessfulLoginTest extends BaseTest {
    MyAccountPage myAccountPage;
    HeaderBar headerBar;

    String email = "katinukai@gmail.com";
    String username = "katinukai123";
    String password = "katinukai";
    String unknownEmailAddressText = "Unknown email address. Check again or try your username.";
    String unknownUsernameText =
            "Error: The username "+username+" is not registered on this site. " +
                    "If you are unsure of your username, try your email address instead.";
    String usernameIsRequiredText = "Error: Username is required.";
    String passwordIsRequiredText = "Error: The password field is empty.";

    @Test
    public void unableToLoginWithInvalidEmailTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.fillEmail(email);
        myAccountPage.fillPassword(password);

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.errorAlert()).isEqualTo(unknownEmailAddressText);
    }

    @Test
    public void unableToLoginWithInvalidUsernameTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.fillUsername(username);
        myAccountPage.fillPassword(password);

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.errorAlert()).isEqualTo(unknownUsernameText);
    }

    @Test
    public void unableToLoginIfUsernameEmailFieldLeftEmpty() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.fillPassword(password);

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.errorAlert()).isEqualTo(usernameIsRequiredText);
    }

    @Test
    public void unableToLoginIfPasswordFieldLeftEmpty() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.fillUsername(username);

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.errorAlert()).isEqualTo(passwordIsRequiredText);
    }

    @Test
    public void unableToLoginIfEmailUsernameAndPasswordFieldsLeftEmpty() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.errorAlert()).isEqualTo(usernameIsRequiredText);
    }
}
