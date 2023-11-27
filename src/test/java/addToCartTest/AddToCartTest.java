package addToCartTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ShopPage;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.*;

public class AddToCartTest extends BaseTest {
    ShopPage shopPage;

    String totalAmountText = "1 item";

    @Test
    public void viewCartButtonAppearsAfterAddedToCartTest() {
        shopPage = new ShopPage(driver);

        shopPage.addProductToCart();

        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        assertThat(shopPage.viewCartButton()).isTrue();
    }

    @Test
    public void whenProductAddedToCartInformationInCartBlockAtTheTopUpdated() {
        shopPage = new ShopPage(driver);

        shopPage.addProductToCart();

        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        assertThat(shopPage.totalSumIsUpdated()).isEqualTo(shopPage.productPrice());
        assertThat(shopPage.itemAmountUpdated()).isEqualTo(totalAmountText);
    }
}
