package shopPageTest;

import org.junit.jupiter.api.Test;
import pages.ShopPage;

import static org.assertj.core.api.Assertions.*;

public class ProductPagesNavigationTest extends BaseTest {
    ShopPage shopPage;

    String nextPage = "2";
    String previousPage = "1";

    @Test
    public void navigationWithArrowsTest() {
        shopPage = new ShopPage(driver);

        shopPage.clickArrowForward();
        assertThat(shopPage.redirectedTo()).contains(nextPage);

        shopPage.clickArrowBack();
        assertThat(shopPage.redirectedTo()).contains(previousPage);
    }
}
