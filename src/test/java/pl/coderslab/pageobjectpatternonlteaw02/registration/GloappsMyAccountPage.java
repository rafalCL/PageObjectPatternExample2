package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// this is our class implementing a page object pattern
public class GloappsMyAccountPage {
    @FindBy(css = "p.alert-success")
    private WebElement registrationConfirm;

    public GloappsMyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isRegistrationSuccess() {
        return registrationConfirm.getText().equals("Your account has been created.");
    }
}
