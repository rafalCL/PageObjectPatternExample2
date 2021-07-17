package pl.coderslab.pageobjectpatternonlteaw02.registration;

import java.time.Month;

public class PersonalInformationFormData {
    private boolean isMr;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int days;
    private Month months;
    private int years;
    private boolean isNewsletter;
    private boolean isSpecialOffers;

    public boolean isMr() {
        return isMr;
    }

    public PersonalInformationFormData setMr(boolean mr) {
        isMr = mr;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonalInformationFormData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonalInformationFormData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonalInformationFormData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PersonalInformationFormData setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getDays() {
        return days;
    }

    public PersonalInformationFormData setDays(int days) {
        this.days = days;
        return this;
    }

    public Month getMonths() {
        return months;
    }

    public PersonalInformationFormData setMonths(Month months) {
        this.months = months;
        return this;
    }

    public int getYears() {
        return years;
    }

    public PersonalInformationFormData setYears(int years) {
        this.years = years;
        return this;
    }

    public boolean isNewsletter() {
        return isNewsletter;
    }

    public PersonalInformationFormData setNewsletter(boolean newsletter) {
        isNewsletter = newsletter;
        return this;
    }

    public boolean isSpecialOffers() {
        return isSpecialOffers;
    }

    public PersonalInformationFormData setSpecialOffers(boolean specialOffers) {
        isSpecialOffers = specialOffers;
        return this;
    }
}
