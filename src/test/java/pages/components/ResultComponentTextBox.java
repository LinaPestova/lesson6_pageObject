package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponentTextBox {
    public void checkResult(String key, String value){
        $("#output")
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}
