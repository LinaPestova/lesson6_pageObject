package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponentPracticeForm;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genderWrapper = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            calendarInput = $("#dateOfBirthInput"),
                            subjectsInput = $("#subjectsInput"),
                            hobbiesInput = $("#hobbiesWrapper"),
                            uploadPicture = $("#uploadPicture"),
                            currentAddressInput = $("#currentAddress"),
                            stateInput = $("#state"),
                            cityInput = $("#city"),
                            buttonSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponentPracticeForm resultComponent = new ResultComponentPracticeForm();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobby(String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value){
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value){
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setSubmit(){
        buttonSubmit.click();
        return this;
    }

    public RegistrationPage checkResultForm(String key, String value) {
        resultComponent.checkResult(key, value);
        return this;
    }
    public RegistrationPage checkEmptyFirstName() {
        firstNameInput.shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
        return this;
    }
}
