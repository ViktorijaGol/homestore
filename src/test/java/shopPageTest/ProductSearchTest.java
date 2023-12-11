package shopPageTest;

import bars.HeaderBar;
import org.junit.jupiter.api.Test;
import pages.ShopPage;
import base.BaseTest;

import static org.assertj.core.api.Assertions.*;

public class ProductSearchTest extends BaseTest {
    ShopPage shopPage;
    HeaderBar headerBar;

    @Test
    public void searchForExistingProductTest() {
        shopPage = new ShopPage(driver);
        headerBar = new HeaderBar(driver);

        String existingProductName = "couch";
        String someProductsWereFoundText = "Search results: “"+existingProductName+"”";
        String resultsCountText = "Showing all 2 results";

        headerBar.typeExistingProductName(existingProductName);
        assertThat(shopPage.searchResults()).isEqualTo(someProductsWereFoundText);
        assertThat(shopPage.resultsCount()).isEqualTo(resultsCountText);
    }
    @Test
    public void searchWithSearchBarLeftEmptyTest() {
        shopPage = new ShopPage(driver);
        headerBar = new HeaderBar(driver);

        String allProductWereFoundText = "Search results: “”";

        headerBar.clickSearchWhenLeftEmpty();
        assertThat(shopPage.searchResults()).isEqualTo(allProductWereFoundText);
    }
    @Test
    public void searchForNonExistingProductTest() {
        shopPage = new ShopPage(driver);
        headerBar = new HeaderBar(driver);

        String nonExistingProductName = "dog";
        String noProductsWereFoundText = "No products were found matching your selection.";

        headerBar.typeNonExistingProductName(nonExistingProductName);
        assertThat(shopPage.noProductsWereFound()).isEqualTo(noProductsWereFoundText);
    }
}
