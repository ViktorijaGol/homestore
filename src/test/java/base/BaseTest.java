package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://themes.woocommerce.com/homestore/shop/");
    }

    @AfterEach
    public void closeBrowser() { driver.close(); }
}
