package addToCartTest;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ShopPage;
import utils.WaitUtils;
import base.BaseTest;

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

    @Test
    public void addToCartClickCartInformationBlockNavigateToCartTest() {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);

        shopPage.addProductToCart();

        shopPage.clickCartBlock();
        assertThat(cartPage.cartDisplayed()).isTrue();
    }
}
