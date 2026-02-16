import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


public class TestPracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void checkPracticeForm(){
        //Есть проблемы с переходом на прямую по урлу https://demoqa.com/automation-practice-form была сделана такая альтернатива
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$ (".router-link").findBy(text("Practice Form")).click();

        //Заполняем данными форму practice-form
        $("#firstName").setValue("Poli");
        $("#lastName").setValue("Levyrv");
        $("#userEmail").setValue("wet@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1999")).click();
        $(".react-datepicker__month").$(byText("14")).click();
        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete=list").sendKeys("m");
        $(byText("Maths")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpeg");
        $("#currentAddress").setValue("Seaview Avenue");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        $("#submit").click();

        //Проверки
        $(".table-responsive").$(byText("Student Name")) .parent().shouldHave(text("Poli Levyrv"));
        $(".table-responsive").$(byText("Student Email")) .parent().shouldHave(text("wet@mail.ru"));
        $(".table-responsive").$(byText("Gender")) .parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")) .parent().shouldHave(text("8800555353"));
        $(".table-responsive").$(byText("Date of Birth")) .parent().shouldHave(text("14 May,1999"));
        $(".table-responsive").$(byText("Subjects")) .parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")) .parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")) .parent().shouldHave(text("test.jpeg"));
        $(".table-responsive").$(byText("Address")) .parent().shouldHave(text("Seaview Avenue"));
        $(".table-responsive").$(byText("State and City")) .parent().shouldHave(text("Uttar Pradesh Agra"));
    }
}
