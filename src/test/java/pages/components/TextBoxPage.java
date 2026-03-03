package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private SelenideElement nameInput = $("#userName"),
            emailInput = $("#userEmail"),
            addressInput = $("#currentAddress"),
            registrationInput = $("#permanentAddress"),
            submitInput = $("#submit"),
            resultInput = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage submitPage() {
        submitInput.click();

        return this;
    }

    public TextBoxPage setName(String value) {
        nameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public TextBoxPage setRegistration(String value) {
        registrationInput.setValue(value);

        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        resultInput.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
