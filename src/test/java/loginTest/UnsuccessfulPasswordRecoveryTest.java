package loginTest;

import bars.HeaderBar;
import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LostPasswordPage;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnsuccessfulPasswordRecoveryTest extends BaseTest {
    MyAccountPage myAccountPage;
    HeaderBar headerBar;
    LostPasswordPage lostPasswordPage;
    @ParameterizedTest
    @CsvSource({"katinukai123, Invalid username or email., You have exceeded the password reset limit. Please wait a few minutes and try again.",
                "katinukai@gmail.com, Invalid username or email., You have exceeded the password reset limit. Please wait a few minutes and try again."})
    public void unableToRecoverPasswordWithInvalidCredentialTest(String usernameOrEmail, String invalidError, String resetLimitError) {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.fillUsernameEmailField(usernameOrEmail);
        lostPasswordPage.clickResetPassword();
        assertTrue(
                (lostPasswordPage.passwordRecoveryError()).equals(invalidError)
                        || (lostPasswordPage.passwordRecoveryError()).equals(resetLimitError));
    }

    @Test
    public void unableToRecoverPasswordIfUsernameEmailFieldLeftEmptyTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        String errorText = "Enter a username or email address.";

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.clickResetPassword();
        assertThat(lostPasswordPage.passwordRecoveryError()).isEqualTo(errorText);
    }
}
