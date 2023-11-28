package loginTest;

import bars.HeaderBar;
import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LostPasswordPage;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnsuccessfulPasswordRecoveryTest extends BaseTest {
    MyAccountPage myAccountPage;
    HeaderBar headerBar;
    LostPasswordPage lostPasswordPage;
    String invalidUsernameOrEmailErrorText = "Invalid username or email.";
    String enterUsernameOrEmailErrorText = "Enter a username or email address.";
    String passwordResetLimitExceededText =
            "You have exceeded the password reset limit. Please wait a few minutes and try again.";
    @ParameterizedTest
    @ValueSource(strings = {"katinukai123", "katinukai@gmail.com"})
    public void unableToRecoverPasswordWithInvalidCredentialTest(String usernameOrEmail) {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.fillUsernameEmailField(usernameOrEmail);
        lostPasswordPage.clickResetPassword();
        assertTrue(
                (lostPasswordPage.passwordRecoveryError()).equals(invalidUsernameOrEmailErrorText)
                        || (lostPasswordPage.passwordRecoveryError()).equals(passwordResetLimitExceededText));
    }

    @Test
    public void unableToRecoverPasswordIfUsernameEmailFieldLeftEmptyTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.clickResetPassword();
        assertThat(lostPasswordPage.passwordRecoveryError()).isEqualTo(enterUsernameOrEmailErrorText);
    }
}
