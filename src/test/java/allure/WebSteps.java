package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную странцу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repository);
        $("#query-builder-test").pressEnter();
    }

    @Step("Кликаем по ссылке резпозиторая {repository}")
    public void clickRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем таб Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issueNumber}")
    public void checkIssue(int issueNumber) {
        $(withText("#" + issueNumber)).should(Condition.exist);
    }
}
