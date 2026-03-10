package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private  SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $(".subjects-auto-complete__input"),
            autocompleteInput = $("[aria-autocomplete='list']"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput= $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            locationInput = $("#stateCity-wrapper"),
            submitInput = $("#submit"),
            tableInput = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("document.getElementById('fixedban')?.remove(); document.querySelector('footer')?.remove();");

        return this;
    }

    public RegistrationPage submitPage() {
        submitInput.click();

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String key, String value) {
        subjectsInput.click();
        autocompleteInput.sendKeys(key);
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setCityLocation(String state, String city) {
        stateInput.click();
        locationInput.$(byText(state)).click();
        cityInput.click();
        locationInput.$(byText(city)).click();

        return this;
    }
    public RegistrationPage checkResult(String key, String value) {
        tableInput.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}