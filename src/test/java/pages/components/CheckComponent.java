package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponent {

    public CheckComponent checkResultTextBoxPage(String key, String value) {
        $("#output").$(byText(key)).shouldHave(text(value));
        return this;
    }

    public CheckComponent checkResultRegistrationPage(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
