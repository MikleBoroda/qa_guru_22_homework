package ui_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void actionMethod() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release()
                .build()
                .perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropMethod() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}