package pl.coderslab.pageobjectpatternonlteaw02.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    @FindBy(id = "account-creation_form")
    private WebElement personalInformationForm;
    @FindBy(id = "id_gender1")
    private WebElement mrRadioBtn;
    @FindBy(id = "id_gender2")
    private WebElement mrsRadioBtn;
    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "days")
    private WebElement daysDropDown;
    @FindBy(id = "months")
    private WebElement monthsDropDown;
    @FindBy(id = "years")
    private WebElement yearsDropDown;
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id = "option")
    private WebElement specialOffersCheckbox;
    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isPersonalInformationFormDisplayed() {
        return personalInformationForm.isDisplayed();
    }

//    public boolean isEmailPopulatedWith(String expected) {
//        String actual = emailInput.getText();
//        return actual.equals(expected);
//    }

    public void fillPersonalInformation(PersonalInformationFormData formData) {
        if (formData.isMr()) {
            mrRadioBtn.click();
        } else {
            mrsRadioBtn.click();
        }
        setInput(customerFirstNameInput, formData.getFirstName());
        setInput(customerLastNameInput, formData.getLastName());
        setInput(passwordInput, formData.getPassword());
        daysDropDown.sendKeys(String.valueOf(formData.getDays()));
        monthsDropDown.sendKeys(formData.getMonths().name());
        yearsDropDown.sendKeys(String.valueOf(formData.getYears()));
        if (formData.isNewsletter()) {
            newsletterCheckbox.click();
        }
        if (formData.isSpecialOffers()) {
            specialOffersCheckbox.click();
        }
    }

    public void submit() {
        submitButton.click();
    }

    private void setInput(WebElement input, String value) {
        input.clear();
        input.sendKeys(value);
    }
}
