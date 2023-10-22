package ui_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.svo.aero";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1680x1050";
    }
}
