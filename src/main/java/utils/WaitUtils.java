package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static final Duration DEFAULT_DURATION = Duration.ofSeconds(5);
    public static void waitForElementVisibility(WebDriver driver, WebElement element, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(d -> element.isDisplayed());
    }
    public static void waitForElementVisibilityHardcoded(WebDriver driver, WebElement element) {
        waitForElementVisibility(driver, element, DEFAULT_DURATION);
    }
}
