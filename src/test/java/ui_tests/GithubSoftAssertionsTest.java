package ui_tests;

<<<<<<< HEAD

=======
>>>>>>> origin/master
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
<<<<<<< HEAD
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
=======
>>>>>>> origin/master
import static com.codeborne.selenide.Selenide.*;

public class GithubSoftAssertionsTest {
    @Test
    void checkCodeSoftAssertionsPage() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
        open("https://github.com/");

        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
<<<<<<< HEAD
        $("[data-testid='results-list']").$("div", 0).$("a").click();
        $("#wiki-tab").click();
        $(".Box-title").shouldHave(text("Pages"));
        $(".wiki-pages-box").$(byText("Show 2 more pages…")).click();
        $(".wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").$(withTagAndText("h4", "3. Using JUnit5 extend test class:"))
                .sibling(0).shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                                                
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }
                        """));
=======
        $x(".//div//span//ancestor::a[@href='/selenide/selenide']").click();
        $x(".//div[@id='repository-container-header']//li//a[@id='wiki-tab']").click();
        $x(".//a[contains(text(),\"Soft assertions\")]").click();
        $x(".//h4[contains(text(),\"JUnit5\")]").shouldHave(text("Using JUnit5 extend test class:"));
        $x(".//h4[contains(text(),\"JUnit5\")]/following::span[contains(text(),\"SoftAssertsExtension\")]")
                .shouldHave(text("SoftAssertsExtension"));
>>>>>>> origin/master
    }
}