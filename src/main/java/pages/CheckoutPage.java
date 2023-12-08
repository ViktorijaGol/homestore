package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Checkout']")
    WebElement checkoutPage;
    public boolean checkoutDisplayed() { return checkoutPage.isDisplayed();
    }

    @FindBy(css = "#order_review")
    WebElement orderReview;
    public boolean productInfoBlockIsDisplayed() { return orderReview.isDisplayed();
    }

    @FindBy(css = "td[class='product-name']")
    WebElement productTitleAndCount;
    public boolean productTitleAndCountIsDisplayed() { return productTitleAndCount.isDisplayed();
    }

    @FindBy(css = "tr[class='cart-subtotal'] td")
    WebElement subtotalSum;
    public boolean subtotalSumIsDisplayed() { return subtotalSum.isDisplayed();
    }

    @FindBy(css = ".wc_payment_methods.payment_methods.methods")
    WebElement message;
    public String messageAboutFillingDetails() { return message.getText();
    }

    @FindBy(css = "#place_order")
    WebElement placeOrderButton;
    public boolean placeOrderButtonIsDisplayed() { return placeOrderButton.isDisplayed();
    }
    public void clickPlaceOrder() { placeOrderButton.click();
    }

    @FindBy(css = "#billing_first_name")
    WebElement firstNameField;
    public void fillFirstName(String firstName) { firstNameField.sendKeys(firstName);
    }

    @FindBy(css = "#billing_last_name")
    WebElement lastNameField;
    public void fillLastName(String lastName) { lastNameField.sendKeys(lastName);
    }

    @FindBy(css = "#billing_address_1")
    WebElement streetAdressField;
    public void fillStreetAdress(String adress) { streetAdressField.sendKeys(adress);
    }

    @FindBy(css = "#billing_city")
    WebElement cityField;
    public void fillCity(String city) { cityField.sendKeys(city);
    }

    @FindBy(css = "#billing_state")
    WebElement stateField;
    public void fillState(String state) { stateField.sendKeys(state);
    }

    @FindBy(css = "#billing_postcode")
    WebElement postcodeField;
    public void fillPostcode(String postcode) { postcodeField.sendKeys(postcode);
    }

    @FindBy(css = "#billing_phone")
    WebElement phoneField;
    public void fillPhone(String phone) { phoneField.sendKeys(phone);
    }

    @FindBy(css = "#billing_email")
    WebElement emailField;
    public void fillEmail(String email) { emailField.sendKeys(email);
    }

    @FindBy(css = "ul[role='alert']")
    WebElement alert;
    public String alertMessage() { return alert.getText();
    }
    public WebElement getAlert() {
        return alert;
    }

    @FindBy(css = "#select2-billing_country-container")
    WebElement countrySelection;
    @FindBy(css = "#billing_country")
    WebElement countryDropbox;
    public void selectCountry(String country) {
        countrySelection.click();
        Select dropdown = new Select(countryDropbox);
        dropdown.selectByVisibleText(country);
        countrySelection.click();
    }
}
