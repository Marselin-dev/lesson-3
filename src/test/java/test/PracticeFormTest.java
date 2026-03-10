package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static testData.ResultData.*;
import static testData.UserData.*;


public class PracticeFormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulScenarioInAutomationPracticeForm() {
        //Открывает practice-form и заполняем полными данными
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setGender(GENDER)
                .setUserNumber(PHONE_NUMBER)
                .setDateOfBirth(DAY, MONTH, YEAR)
                .setSubjects(SUBJECTS_KEY, TOPIC)
                .setHobbies(HOBBY)
                .setUploadPicture(PICTURE)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setCityLocation(STATE, CITY)
                .submitPage()
                //Проверки формы после отправки данных
                .checkResult(STUDENT_NAME, NAME)
                .checkResult(STUDENT_EMAIL, EMAIL)
                .checkResult(STUDENT_GENDER, GENDER)
                .checkResult(STUDENT_MOBILE, PHONE_NUMBER)
                .checkResult(STUDENT_BRITHDAY, BRITHDAY)
                .checkResult(STUDENT_SUBJECTS, TOPIC)
                .checkResult(STUDENT_HOBBIES, HOBBY)
                .checkResult(STUDENT_PHOTO, PICTURE)
                .checkResult(STUDENT_ADDRESS, CURRENT_ADDRESS)
                .checkResult(STUDENT_REGISTRATION, REGISTRATION);

    }

    @Test
    void incompleteSuccessfulScenarioAutomationPracticeForm(){
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setGender(GENDER)
                .setUserNumber(PHONE_NUMBER)
                .submitPage()
                .checkResult(STUDENT_NAME, NAME)
                .checkResult(STUDENT_EMAIL, EMAIL)
                .checkResult(STUDENT_GENDER, GENDER)
                .checkResult(STUDENT_MOBILE, PHONE_NUMBER);


    }
}
