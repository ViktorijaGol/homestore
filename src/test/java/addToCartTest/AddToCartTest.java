package addToCartTest;

import org.junit.jupiter.api.Test;
import pages.ShopPage;
import utils.WaitUtils;
import base.BaseTest;

import static org.assertj.core.api.Assertions.*;

public class AddToCartTest extends BaseTest {
    ShopPage shopPage;

    String totalAmountText = "1 item";
    String subtotalSumInTheCart = "£200.00";
    String itemAmountAndSumInTheCart = "1 × "+subtotalSumInTheCart+"";

    @Test
    public void viewCartButtonAppearsAfterAddedToCartTest() {
        shopPage = new ShopPage(driver);

        shopPage.addProductToCart();

        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        assertThat(shopPage.viewCartButton()).isTrue();
    }

    @Test
    public void informationInTopCartBlockDisplayed() {
        shopPage = new ShopPage(driver);

        shopPage.addProductToCart();

        WaitUtils.waitForElementVisibilityHardcoded(driver, shopPage.getElement());
        assertThat(shopPage.totalSumIsUpdated()).isEqualTo(shopPage.productPrice());
        assertThat(shopPage.itemAmountUpdated()).isEqualTo(totalAmountText);

        shopPage.hoverCartBlock();
        assertThat(shopPage.productTitleVisible()).isEqualTo(shopPage.productTitleInTheShop());
        assertThat(shopPage.productAmountAndSumVisible()).isEqualTo(itemAmountAndSumInTheCart);
        assertThat(shopPage.subtotalSumIsVisible()).isEqualTo(subtotalSumInTheCart);
        assertThat(shopPage.viewCartButtonIsVisible()).isTrue();
        assertThat(shopPage.checkoutButtonIsVisible()).isTrue();
    }
}
