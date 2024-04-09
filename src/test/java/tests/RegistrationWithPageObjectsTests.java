package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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
                .setSubmit()

                .checkResultForm("Student Name", "Ivanna Ivanova")
                .checkResultForm("Student Email", "sobaka@sobaka.ru")
                .checkResultForm("Gender", "Female")
                .checkResultForm("Mobile", "7999999999")
                .checkResultForm("Date of Birth", "30 July,2008")
                .checkResultForm("Subjects", "Math")
                .checkResultForm("Hobbies", "Music")
                .checkResultForm("Picture", "test pic.jpg")
                .checkResultForm("Address", "New address")
                .checkResultForm("State and City", "NCR Delhi");

    }

    @Test
    void minimumRequiredFields() {
        registrationPage.openPage();

        registrationPage.setFirstName("Ivanna")
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("79999999999")
                .setSubmit()

                .checkResultForm("Student Name", "Ivanna Ivanova")
                .checkResultForm("Gender", "Female")
                .checkResultForm("Mobile", "7999999999");
    }

    @Test
    void errorTestWithNoRequiredFirstName() {
        registrationPage.openPage();

        registrationPage.setFirstName("")
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
                .setSubmit()

                .checkEmptyFirstName();
    }
}
