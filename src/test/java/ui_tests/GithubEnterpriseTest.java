package ui_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubEnterpriseTest {
    @Test
    void checkEnterprisePage() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
        open("https://github.com/");

        $("div.header-menu-wrapper").$(byText("Solutions")).hover();
        $("div.header-menu-wrapper").$(byTagAndText("a", "Enterprise")).click();
        $(byTagAndText("h1", "Build like the best")).shouldBe(visible);
    }
}