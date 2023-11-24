import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;
    HeaderBar headerBar;

    String email = "katinukai@gmail.com";
    String username = "katinukai";
    String password = "katinukai";
    String unknownEmailAdressText = "Unknown email address. Check again or try your username.";
    String unknownUsernameText = "Error: The username "+username+" is not registered on this site. If you are unsure of your username, try your email address instead.";

    @Test
    public void unableToLoginWithInvalidEmailTest() {
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.fillEmail(email);
        myAccountPage.fillPassword(password);

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.unknownEmailAdressError()).isEqualTo(unknownEmailAdressText);
    }

    @Test
    public void unableToLoginWithInvalidUsernameTest() {
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.fillUsername(username);
        myAccountPage.fillPassword(password);

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.unknownUsernameError()).isEqualTo(unknownUsernameText);
    }
}
