package ui_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubSoftAssertionsTest {
    @Test
    void checkCodeSoftAssertionsPage() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
        open("https://github.com/");

        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $x(".//div//span//ancestor::a[@href='/selenide/selenide']").click();
        $x(".//div[@id='repository-container-header']//li//a[@id='wiki-tab']").click();
        $x(".//a[contains(text(),\"Soft assertions\")]").click();
        $x(".//h4[contains(text(),\"JUnit5\")]").shouldHave(text("Using JUnit5 extend test class:"));
        $x(".//h4[contains(text(),\"JUnit5\")]/following::span[contains(text(),\"SoftAssertsExtension\")]")
                .shouldHave(text("SoftAssertsExtension"));
    }
}