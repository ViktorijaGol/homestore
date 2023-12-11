package loginTest;

import bars.HeaderBar;
import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.*;

public class UnsuccessfulLoginTest extends BaseTest {
    MyAccountPage myAccountPage;
    HeaderBar headerBar;

    @ParameterizedTest
    @CsvFileSource(resources = "/unsuccessfulLoginTest.csv")
    public void unableToLoginWithInvalidCredentialsTest(String usernameEmail, String password, String alert) {
        myAccountPage = new MyAccountPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickMyAccount();

        myAccountPage.fillEmailUsernameField(usernameEmail);
        myAccountPage.fillPassword(password);

        myAccountPage.checkRememberMe();
        myAccountPage.clickLogin();

        assertThat(myAccountPage.errorAlert()).contains(alert);
    }
}