package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            hobbiesSelect = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateCitySelect = $("#stateCity-wrapper"),
            submit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGenderWrapper(String genderWrapper) {
        genderWrapperInput.$(byText(genderWrapper)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage upLoadPicture(String fileNamePicture) {
        uploadPicture.uploadFromClasspath(fileNamePicture);
        return this;
    }

    public RegistrationPage selectHobbies(String hobbies) {
        hobbiesSelect.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectStateCity(String state, String city) {
        $("#state").click();
        stateCitySelect.$(byText(state)).click();

        $("#city").click();
        stateCitySelect.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submit() {
        submit.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
