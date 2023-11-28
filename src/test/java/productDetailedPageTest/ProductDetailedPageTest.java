package productDetailedPageTest;

import org.junit.jupiter.api.Test;
import pages.ProductDetailedPage;
import pages.ShopPage;

import static org.assertj.core.api.Assertions.*;

public class ProductDetailedPageTest extends BaseTest {
    ShopPage shopPage;
    ProductDetailedPage productDetailedPage;

    String productTitle = "Classic TV stand";
    String amountLarge = "14";
    String alertTextOne = "View cart\n"+amountLarge+" × “"+productTitle+"” have been added to your cart.";
    String alertTextTwo = "View cart\n2 × “"+productTitle+"” have been added to your cart.";
    String alertTextThree = "View cart\n“"+productTitle+"” has been added to your cart.";

    @Test
    public void productDetailedPageContainsAllRequestedInformationTest() {
        shopPage = new ShopPage(driver);
        productDetailedPage = new ProductDetailedPage(driver);

        shopPage.clickOnProduct();
        assertThat(productDetailedPage.productTitle()).isEqualTo(productTitle);

        assertThat(productDetailedPage.productPriceVisible()).isTrue();
        assertThat(productDetailedPage.productDescriptionVisible()).isTrue();
        assertThat(productDetailedPage.productCategoryVisible());
    }

    @Test
    public void userChooseProductAmountByEnteringNumbersTest() {
        shopPage = new ShopPage(driver);
        productDetailedPage = new ProductDetailedPage(driver);

        shopPage.clickOnProduct();
        assertThat(productDetailedPage.productTitle()).isEqualTo(productTitle);

        productDetailedPage.chooseAmount(amountLarge);
        productDetailedPage.addToCart();

        assertThat(productDetailedPage.addedToCartAssertVisible()).isEqualTo(alertTextOne);
        assertThat(productDetailedPage.viewCartButtonAppears()).isTrue();
    }

    @Test
    public void userChooseProductAmountByClickingArrowsTest() {
        shopPage = new ShopPage(driver);
        productDetailedPage = new ProductDetailedPage(driver);

        shopPage.clickOnProduct();
        assertThat(productDetailedPage.productTitle()).isEqualTo(productTitle);

        productDetailedPage.chooseAmountWithArrows();
        productDetailedPage.addToCart();

        assertThat(productDetailedPage.addedToCartAssertVisible()).isEqualTo(alertTextTwo);
        assertThat(productDetailedPage.viewCartButtonAppears()).isTrue();
    }

    @Test
    public void userLeavesQuantityInputEmptyTest() {
        shopPage = new ShopPage(driver);
        productDetailedPage = new ProductDetailedPage(driver);

        shopPage.clickOnProduct();
        assertThat(productDetailedPage.productTitle()).isEqualTo(productTitle);

        productDetailedPage.leaveAmountEmpty();
        productDetailedPage.addToCart();

        assertThat(productDetailedPage.addedToCartAssertVisible()).isEqualTo(alertTextThree);
        assertThat(productDetailedPage.viewCartButtonAppears()).isTrue();
    }
}

