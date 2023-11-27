package addToCartTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ShopPage;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.*;

public class AddToCartAndNavigateToCartPageTest extends BaseTest {

    ShopPage shopPage;
    CartPage cartPage;

    @Test
    public void addToCartClickViewCartNavigateToCartTest() {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);

        shopPage.addProductToCart();

        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        shopPage.clickNavigateToCart();

        assertThat(cartPage.cartDisplayed()).isTrue();
    }
}
