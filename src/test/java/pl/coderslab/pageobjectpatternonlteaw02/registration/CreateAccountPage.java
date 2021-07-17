package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    @FindBy(id = "account-creation_form")
    private WebElement personalInformationForm;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isPersonalInformationFormDisplayed() {
        return personalInformationForm.isDisplayed();
    }
}
