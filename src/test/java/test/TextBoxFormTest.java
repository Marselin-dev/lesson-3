package test;

import org.junit.jupiter.api.Test;
import pages.components.TextBoxPage;

import static testData.ResultData.*;
import static testData.UserData.*;


public class TextBoxFormTest extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

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
