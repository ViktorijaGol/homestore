package shopPageTest;

import bars.HeaderBar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ShopPage;

import static org.assertj.core.api.Assertions.*;

public class ProductSearchTest extends BaseTest{
    ShopPage shopPage;
    HeaderBar headerBar;

    String existingProductName = "couch";
    String nonExistingProductName = "dog";
    String noProductsWereFoundText = "No products were found matching your selection.";
    String someProductsWereFoundText = "Search results: “"+existingProductName+"”";
    String allProductWereFoundText = "Search results: “”";
    String resultsCountText = "Showing all 2 results";
    @Test
    public void searchForExistingProductTest() {
        shopPage = new ShopPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.typeExistingProductName(existingProductName);
        assertThat(shopPage.searchResults()).isEqualTo(someProductsWereFoundText);
        assertThat(shopPage.resultsCount()).isEqualTo(resultsCountText);
    }
    @Test
    public void searchWithSearchBarLeftEmptyTest() {
        shopPage = new ShopPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.clickSearchWhenLeftEmpty();
        assertThat(shopPage.searchResults()).isEqualTo(allProductWereFoundText);
    }
    @Test
    public void searchForNonExistingProductTest() {
        shopPage = new ShopPage(driver);
        headerBar = new HeaderBar(driver);

        headerBar.typeNonExistingProductName(nonExistingProductName);
        assertThat(shopPage.noProductsWereFound()).isEqualTo(noProductsWereFoundText);
    }
}
