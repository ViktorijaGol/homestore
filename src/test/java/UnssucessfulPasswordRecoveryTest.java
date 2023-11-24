import org.junit.jupiter.api.Test;

public class UnssucessfulPasswordRecoveryTest extends BaseTest {
    MyAccountPage myAccountPage;
    HeaderBar headerBar;
    LostPasswordPage lostPasswordPage;

    String username = "katinukai123";
    String email = "katinukai@gmail.com";

    @Test
    public void unableToRecoverPasswordWithInvalidUsernameTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.fillUsername(username);
    }

    @Test
    public void unableToRecoverPasswordWithInvalidEmailTest() {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);
        lostPasswordPage = new LostPasswordPage(driver);

        headerBar.clickMyAccount();

        myAccountPage.clickLostYourPassword();

        lostPasswordPage.fillEmail(email);
    }
}
