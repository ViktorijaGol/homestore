package productDetailedPageTest;

import org.junit.jupiter.api.Test;
import pages.ProductDetailedPage;
import pages.ShopPage;

import static org.assertj.core.api.Assertions.*;

public class ProductDetailedPageInformationTest extends BaseTest {
    ShopPage shopPage;
    ProductDetailedPage productDetailedPage;

    String productTitle = "Classic TV stand";

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
}
