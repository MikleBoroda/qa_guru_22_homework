package ui_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @Test
    void fillingAndCheckingFrom() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //заполнение формы
        $("#firstName").setValue("Mixa");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("test@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--008").click();
        $(".subjects-auto-complete__input #subjectsInput").click();
        $(".subjects-auto-complete__input #subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
        $("#uploadPicture").uploadFromClasspath("PictureFirst.png");
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#currentAddress").setValue("Vladimir city");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        //проверка формы
        $(".table-responsive")
                .shouldHave(Condition.text("Mixa Smith"))
                .shouldHave(Condition.text("test@mail.ru"))
                .shouldHave(Condition.text("Male"))
                .shouldHave(Condition.text("9991112233"))
                .shouldHave(Condition.text("08 September,2000"))
                .shouldHave(Condition.text("Maths"))
                .shouldHave(Condition.text("Sports, Reading"))
                .shouldHave(Condition.text("PictureFirst.png"))
                .shouldHave(Condition.text("Vladimir city"))
                .shouldHave(Condition.text("Uttar Pradesh Agra"));
    }
}
