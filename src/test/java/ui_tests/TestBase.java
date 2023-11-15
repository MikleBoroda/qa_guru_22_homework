package ui_tests;

import com.codeborne.selenide.Configuration;
import config.TestConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.TextBoxPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void beforeAll() {
        TestConfiguration cnfg = ConfigFactory.create(TestConfiguration.class, System.getProperties());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = cnfg.getBrowserName();
        Configuration.browserVersion = cnfg.getBrowserVersion();
        Configuration.remote = cnfg.getRemoteUrl();

    }
}
