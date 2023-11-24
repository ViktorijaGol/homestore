package loginTest;

import bars.HeaderBar;
import org.junit.jupiter.api.Test;
import pages.LostPasswordPage;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.*;

public class UnssucessfulPasswordRecoveryTest extends BaseTest {
    MyAccountPage myAccountPage;
    HeaderBar headerBar;
    LostPasswordPage lostPasswordPage;

    String username = "katinukai123";
    String email = "katinukai@gmail.com";
    String invalidUsernameOrEmailErrorText = "Invalid username or email.";
    String enterUsernameOrEmailErrorText = "Enter a username or email address.";

    @Test
    public void unableToRecoverPasswordWithInvalidUsernameTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.fillUsername(username);
        lostPasswordPage.clickResetPassword();

        assertThat(lostPasswordPage.invalidUsernameOrEmailError()).isEqualTo(invalidUsernameOrEmailErrorText);
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

        assertThat(lostPasswordPage.invalidUsernameOrEmailError()).isEqualTo(invalidUsernameOrEmailErrorText);
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
