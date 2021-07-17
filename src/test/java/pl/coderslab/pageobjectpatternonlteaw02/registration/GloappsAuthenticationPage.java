package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// this is our class implementing a page object pattern
public class GloappsAuthenticationPage {
    @FindBy(id = "email_create")
    private WebElement emailInput;
    @FindBy(id = "SubmitCreate")
    private WebElement submitButton;

    public GloappsAuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmailForCreateAccount(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void submitCreateAccount() {
        submitButton.click();
    }
}
