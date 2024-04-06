package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void positiveTest(){
        textBoxPage.openPage();

        textBoxPage.setUserName("Ivanna")
                .setUserEmail("sobaka@sobaka.ru")
                .setCurrentAddress("New current address")
                .setPermanentAddress("New permanent address")
                .setSubmit()

                .checkResultForm("Name:", "Ivanna")
                .checkResultForm("Current Address :", "New current address")
                .checkResultForm("Permananet Address :", "New permanent address");

    }
}
