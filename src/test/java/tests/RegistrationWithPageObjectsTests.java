package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void firstTest() {
        registrationPage.openPage();

        registrationPage.setFirstName("Ivanna")
                .setLastName("Ivanova")
                .setEmail("sobaka@sobaka.ru")
                .setGender("Female")
                .setUserNumber("79999999999")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("Math")
                .setHobby("Music")
                .setPicture("test pic.jpg")
                .setCurrentAddress("New address")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();

        $$("tr").get(1).shouldHave(text("Ivanna Ivanova"));
        $$("tr").get(2).shouldHave(text("sobaka@sobaka.ru"));
        $$("tr").get(3).shouldHave(text("Female"));
        $$("tr").get(4).shouldHave(text("7999999999"));
        $$("tr").get(5).shouldHave(text("01 January,2001"));
        $$("tr").get(6).shouldHave(text("Maths"));
        $$("tr").get(7).shouldHave(text("Music"));
        $$("tr").get(8).shouldHave(text("test pic.jpg"));
        $$("tr").get(9).shouldHave(text("New address"));
        $$("tr").get(10).shouldHave(text("NCR Delhi"));
    }
}
