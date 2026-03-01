import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static testData.UserData.*;


public class SiteCheckTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void checkPracticeForm(){
        //Открывает нужный раздел сайта
        open("https://demoqa.com/automation-practice-form");

        //Заполняем данными форму practice-form
        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#userEmail").setValue(EMAIL);
        $("#genterWrapper").$(byText(GENDER)).click();
        $("#userNumber").setValue(PHONE_NUMBER);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(MONTH)).click();
        $(".react-datepicker__year-select").$(byText(YEAR)).click();
        $(".react-datepicker__month").$(byText(DAY)).click();
        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete='list']").sendKeys("m");
        $(byText(TOPIC)).click();
        $("#hobbiesWrapper").$(byText(HOBBY)).click();
        $("#uploadPicture").uploadFromClasspath("test.jpeg");
        $("#currentAddress").setValue(CURRENT_ADDRESS);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(STATE)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(CITY)).click();

        $("#submit").click();

        //Проверки
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(STUDENT_NAME));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(EMAIL));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(GENDER));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(PHONE_NUMBER));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(DATE_OF_BIRTH));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(TOPIC));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(HOBBY));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test.jpeg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(CURRENT_ADDRESS));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(STATE_AND_CITY));
    }

    @Test
    void checkTextBox(){
        //Открывает нужный раздел сайта
        open("https://demoqa.com/text-box");

        //Заполняем данными форму text box
        $("#userName").setValue(STUDENT_NAME);
        $("#userEmail").setValue(EMAIL);
        $("#currentAddress").setValue(CURRENT_ADDRESS);
        $("#permanentAddress").setValue(STATE_AND_CITY);
        $("#submit").click();

        //Проверки
        $("#name").shouldHave(text("Name:" + STUDENT_NAME));
        $("#email").shouldHave(text("Email:" + EMAIL));
        $("#currentAddress").shouldHave(value(CURRENT_ADDRESS));
        $("#permanentAddress").shouldHave(value(STATE_AND_CITY));
    }
}

