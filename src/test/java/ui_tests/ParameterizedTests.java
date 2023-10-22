package ui_tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class ParameterizedTests extends TestBase {

    @CsvSource(value = {
            "ru, Шереметьево",
            "en,  Sheremetyevo"
    })
    @Tag("SMOKE")
    @ParameterizedTest(name = "На главной странице аэропорта проверяем запись {1} на языке {0}")
    void sheremetyevoTest(String language, String titlePage) {
        open("/" + language + "/main");
        $(".main-screen__title .text").shouldHave(Condition.text(titlePage));
    }

    static Stream<Arguments> sheremetyevoButtonsTest() {
        return Stream.of(
                Arguments.of("ru", List.of("Вылет", "Прилет", "Пересадка")),
                Arguments.of("en", List.of("Departures", "Arrivals", "Connections"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "На главной странице аэропорта проверяем кнопки {1} на языке {0}")
    @Tags({@Tag("REGRESS"), @Tag("SMOKE")})
    void sheremetyevoButtonsTest(String language, List<String> expectedButtons) {
        open("/" + language + "/main");
        $$(".navigation main-nav-button").shouldHave(CollectionCondition.texts(expectedButtons));
    }


    @ValueSource(strings = {
            "Табло вылета",
            "Вылетающим",
            "Провожающим",
            "Пассажирам с ОВЗ"
    })
    @Tags({@Tag("BLOCKER"), @Tag("REGRESS")})
    @ParameterizedTest(name = "На странице ВЫЛЕТ проверка навигационной кнопки {0}")
    void toolHasSubmitNotice(String buttons) {
        open("/ru/departure");
        $(".wrapper").shouldHave(Condition.text(buttons));
    }
}