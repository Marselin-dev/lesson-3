import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void checkPracticeForm(){
        //Есть проблемы с переходом на прямую по урлу https://demoqa.com/automation-practice-form была сделана такая альтернатива

        open("https://demoqa.com/");
        $$(".card-body").findBy(text("Forms")).click();
        $(byXpath("//li[@id='item-0']//span[text()='Practice Form']/..")).click();

        //Заполняем данными форму practice-form
        $("#firstName").setValue("Poli");
        $("#lastName").setValue("Levyrv");
        $("#userEmail").setValue("wet@mail.ru");
        $("[value=Female]").click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1999")).click();
        $(".react-datepicker__month").$(byText("14")).click();
        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete=list").sendKeys("m");
        $(byText("Maths")).click();
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/data/test.jpeg"));
        $("#currentAddress").setValue("Seaview Avenue");
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        //Проверки
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Student Name']]/td[2]")).shouldHave(text("Poli Levyrv"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Student Email']]/td[2]")).shouldHave(text("wet@mail.ru"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Gender']]/td[2]")).shouldHave(text("Female"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Mobile']]/td[2]")).shouldHave(text("8800555353"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Date of Birth']]/td[2]")).shouldHave(text("14 May,1999"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Subjects']]/td[2]")).shouldHave(text("Maths"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Hobbies']]/td[2]")).shouldHave(text("Reading"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Picture']]/td[2]")).shouldHave(text("test.jpeg"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='Address']]/td[2]")).shouldHave(text("Seaview Avenue"));
        $(byXpath("//table[contains(@class, 'table-dark')]//tr[td[text()='State and City']]/td[2]")).shouldHave(text("Rajasthan Jaipur"));
    }
}
