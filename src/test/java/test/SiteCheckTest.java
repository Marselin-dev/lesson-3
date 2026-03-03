package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TextBoxPage;


import static testData.ResultData.*;
import static testData.UserData.*;


public class SiteCheckTest extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void checkPracticeForm() {
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
    void checkTextBox(){
        //Открывает text-box-form и заполняем полными данными
        textBoxPage.openPage()
                .setName(NAME)
                .setEmail(EMAIL)
                .setAddress(CURRENT_ADDRESS)
                .setRegistration(REGISTRATION)
                .submitPage()
                //Проверки формы после отправки данных
                .checkResult(USER_NAME, NAME)
                .checkResult(USER_EMAIL, EMAIL)
                .checkResult(USER_ADDRESS, CURRENT_ADDRESS)
                .checkResult(USER_REGISTRATION, REGISTRATION);
    }
}

