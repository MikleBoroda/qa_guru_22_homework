package ui_tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {

    @Test
    void fillingAndCheckingFrom() {
        registrationPage.openPage()
                .setFirstName("Mixa")
                .setLastName("Smith")
                .setUserEmail("test@mail.ru")
                .setGenderWrapper("Other")
                .setUserNumber("9991112233")
                .setDateOfBirth("08", "September", "2000")
                .setSubjects("Maths")
                .upLoadPicture("PictureFirst.png")
                .selectHobbies("Sports")
                .selectHobbies("Reading")
                .setCurrentAddress("Vladimir city")
                .selectStateCity("Uttar Pradesh", "Agra")
                .submit();

        checkComponent.checkResultRegistrationPage("Student Name", "Mixa Smith")
                .checkResultRegistrationPage("Student Email", "test@mail.ru")
                .checkResultRegistrationPage("Gender", "Other")
                .checkResultRegistrationPage("Mobile", "9991112233")
                .checkResultRegistrationPage("Date of Birth", "08 September,2000")
                .checkResultRegistrationPage("Subjects", "Maths")
                .checkResultRegistrationPage("Hobbies", "Sports, Reading")
                .checkResultRegistrationPage("Address", "Vladimir city")
                .checkResultRegistrationPage("State and City", "Uttar Pradesh Agra");
    }
}
