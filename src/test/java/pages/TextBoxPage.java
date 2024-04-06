package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ResultComponentTextBox;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            buttonSubmit = $("#submit");

    ResultComponentTextBox resultComponentTextBox = new ResultComponentTextBox();
    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.click();
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.click();
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setSubmit() {
        buttonSubmit.click();
        return this;
    }

    public TextBoxPage checkResultForm(String key, String value) {
        resultComponentTextBox.checkResult(key, value);
        return this;
    }
}
