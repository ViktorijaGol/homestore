package checkoutTest;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ShopPage;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.*;

public class CheckoutPageTest extends BaseTest{

    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Test
    public void userCanNavigateToCheckoutPageAndSeeAllItsElements() {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        String messageText = "Please fill in your details above to see available payment methods.";

        shopPage.addProductToCart();
        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        shopPage.clickCartBlock();

        cartPage.proceedToCheckout();
        assertThat(checkoutPage.checkoutDisplayed()).isTrue();

        assertThat(checkoutPage.productInfoBlockIsDisplayed()).isTrue();
        assertThat(checkoutPage.productTitleAndCountIsDisplayed()).isTrue();
        assertThat(checkoutPage.subtotalSumIsDisplayed()).isTrue();

        assertThat(checkoutPage.messageAboutFillingDetails()).isEqualTo(messageText);
        assertThat(checkoutPage.placeOrderButtonIsDisplayed()).isTrue();
    }
}
