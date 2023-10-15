package ui_tests;

import datapages.State;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

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
    void fillingAndCheckingFrom() {
        registrationPage.openPage()
                .setFirstName(firstName)
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

        registrationPage.checkResultRegistrationPage("Student Name", firstName + " " + lastName)
                .checkResultRegistrationPage("Student Email", email)
                .checkResultRegistrationPage("Gender", gender)
                .checkResultRegistrationPage("Mobile", phoneNumber)
                .checkResultRegistrationPage("Date of Birth", day + " " + month + "," + year)
                .checkResultRegistrationPage("Subjects", subject)
                .checkResultRegistrationPage("Hobbies", hobbie)
                .checkResultRegistrationPage("Address", currentAddress)
                .checkResultRegistrationPage("State and City", state.description + " " + city);
    }
}
