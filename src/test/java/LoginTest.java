import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;
    HeaderBar headerBar;

    String email = "katinukai@gmail.com";
    String password = "katinukai";
    String unknownEmailAdressText = "Unknown email address. Check again or try your username.";

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

        Assertions.assertThat(myAccountPage.unknownEmailAdressError()).isEqualTo(unknownEmailAdressText);
    }
}
