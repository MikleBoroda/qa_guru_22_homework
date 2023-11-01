package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {
    private static final String REPOSITORY = "selenide/selenide";
    private static final int ISSUE = 2535;

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @DisplayName("Проверка оторбажения Issue")
    @Owner("Mixa")
    @Link(value = "GitHub", url = "https://github.com/")
    @Severity(SeverityLevel.MINOR)
    public void lambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную странцу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });

        step("Кликаем по ссылке резпозиторая " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @DisplayName("Проверка оторбажения Issue")
    @Owner("Mixa")
    @Link(value = "GitHub", url = "https://github.com/")
    @Severity(SeverityLevel.MINOR)
    public void annotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.clickRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.checkIssue(ISSUE);
    }
}
