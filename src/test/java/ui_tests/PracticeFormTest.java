package ui_tests;

import datapages.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;


public class PracticeFormTest extends TestBase {
    RandomUtils randomUtils = new RandomUtils();
    private String firstName = randomUtils.randomFirstName();
    private String lastName = randomUtils.randomLastName();
    private String email = randomUtils.randomEmail();
    private String gender = randomUtils.randomGender().description;
    private String phoneNumber = randomUtils.randomPhoneNumber();
    private String subject = randomUtils.randomSubject().description;
    private String hobbie = randomUtils.randomHobbie().description;
    private String day = randomUtils.randomDay();
    private String month = randomUtils.randomMonth();
    private String year = randomUtils.randomYear();
    private String currentAddress = randomUtils.randomCurrentAddress();
    private State state = randomUtils.randomStateCity();
    private String city = state.city();

    @Test
    @Tag("Smoke")
    @DisplayName("Check registration page")
    void fillingAndCheckingFrom() {
        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(email)
                    .setGenderWrapper(gender)
                    .setUserNumber(phoneNumber)
                    .setDateOfBirth(day, month, year)
                    .setSubjects(subject)
                    .upLoadPicture("PictureFirst.png")
                    .selectHobbies(hobbie)
                    .setCurrentAddress(currentAddress)
                    .selectStateCity(state.description, city)
                    .submit();
        });

        step("Check form", () -> {
            registrationPage.checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbie)
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", state.description + " " + city);
        });
    }
}
