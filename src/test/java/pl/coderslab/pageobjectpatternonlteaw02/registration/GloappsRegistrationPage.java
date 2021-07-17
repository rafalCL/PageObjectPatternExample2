package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// this is our class implementing a page object pattern
public class GloappsRegistrationPage {
    @FindBy(id = "email_create")
    WebElement emailInput;

    public GloappsRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }
}
