package addToCartTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ShopPage;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.*;

public class AddToCartTest extends BaseTest {
    ShopPage shopPage;

    @Test
    public void viewCartButtonAppearsAfterAddedToCartTest() {
        shopPage = new ShopPage(driver);

        shopPage.addProductToCart();
        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        assertThat(shopPage.viewCartButton()).isTrue();
    }
}
