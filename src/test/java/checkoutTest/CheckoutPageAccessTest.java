package checkoutTest;

import base.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ShopPage;
import utils.WaitUtils;

public class CheckoutPageAccessTest extends BaseTest{

    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Test
    public void userCanNavigateToCheckoutPage() {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        shopPage.addProductToCart();
        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        shopPage.clickCartBlock();

        cartPage.proceedToCheckout();
        Assertions.assertThat(checkoutPage.checkoutDisplayed()).isTrue();
    }

}
