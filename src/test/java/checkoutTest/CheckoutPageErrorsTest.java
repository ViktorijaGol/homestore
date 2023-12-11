package checkoutTest;

import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ShopPage;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.*;

public class CheckoutPageErrorsTest extends BaseTest {
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @ParameterizedTest
    @CsvFileSource(resources = "/mandatoryFieldsTest.csv")
    public void correctErrorMessageWhenUserMissesMandatoryFields(
            String firstName, String lastName, String country, String address, String city, String state, String postcode, String phone, String email, String alert) throws InterruptedException {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        shopPage.addProductToCart();
        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        shopPage.clickCartBlock();

        cartPage.proceedToCheckout();

        checkoutPage.fillFirstName(firstName);
        checkoutPage.fillLastName(lastName);
        checkoutPage.selectCountry(country);
        checkoutPage.fillStreetAddress(address);
        checkoutPage.fillCity(city);
        checkoutPage.fillState(state);
        checkoutPage.fillPostcode(postcode);
        checkoutPage.fillPhone(phone);
        checkoutPage.fillEmail(email);

        checkoutPage.clickPlaceOrder();

        WaitUtils.waitForElementVisibilityHardcoded(driver, checkoutPage.getAlert());
        assertThat(checkoutPage.alertMessage()).contains(alert);
    }

    @ParameterizedTest
    @CsvSource({"Viktorija, Golovinova, Griniaus g., Kaunas, Kauno, 48374, +37064830123, viktorija@gmail.com, Billing Country / Region is a required field"})
    public void correctErrorMessageWhenUserMissesCountryField(
            String firstName, String lastName, String address, String city, String state, String postcode, String phone, String email, String alert) throws InterruptedException {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        shopPage.addProductToCart();
        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        shopPage.clickCartBlock();

        cartPage.proceedToCheckout();

        checkoutPage.fillFirstName(firstName);
        checkoutPage.fillLastName(lastName);
        checkoutPage.fillStreetAddress(address);
        checkoutPage.fillCity(city);
        checkoutPage.fillState(state);
        checkoutPage.fillPostcode(postcode);
        checkoutPage.fillPhone(phone);
        checkoutPage.fillEmail(email);

        checkoutPage.clickPlaceOrder();

        WaitUtils.waitForElementVisibilityHardcoded(driver, checkoutPage.getAlert());
        assertThat(checkoutPage.alertMessage()).contains(alert);
    }
}
