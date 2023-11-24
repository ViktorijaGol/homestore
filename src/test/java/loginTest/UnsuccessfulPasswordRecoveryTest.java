package loginTest;

import bars.HeaderBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LostPasswordPage;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UnsuccessfulPasswordRecoveryTest extends BaseTest {
    MyAccountPage myAccountPage;
    HeaderBar headerBar;
    LostPasswordPage lostPasswordPage;

    String username = "katinukai123";
    String email = "katinukai@gmail.com";
    String invalidUsernameOrEmailErrorText = "Invalid username or email.";
    String enterUsernameOrEmailErrorText = "Enter a username or email address.";
    String passwordResetLimitExceededText = "You have exceeded the password reset limit. Please wait a few minutes and try again.";

    @Test
    public void unableToRecoverPasswordWithInvalidUsernameTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.fillUsername(username);
        lostPasswordPage.clickResetPassword();
        assertTrue(
                (lostPasswordPage.invalidUsernameOrEmailError()).equals(invalidUsernameOrEmailErrorText)
                        || (lostPasswordPage.invalidUsernameOrEmailError()).equals(passwordResetLimitExceededText));
    }

    @Test
    public void unableToRecoverPasswordWithInvalidEmailTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.fillEmail(email);
        lostPasswordPage.clickResetPassword();
        assertTrue(
                (lostPasswordPage.invalidUsernameOrEmailError()).equals(invalidUsernameOrEmailErrorText)
                        || (lostPasswordPage.invalidUsernameOrEmailError()).equals(passwordResetLimitExceededText));
    }

    @Test
    public void unableToRecoverPasswordIfUsernameEmailFieldLeftEmptyTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.clickResetPassword();
        assertThat(lostPasswordPage.enterUsernameOrEmailError()).isEqualTo(enterUsernameOrEmailErrorText);
    }
}
