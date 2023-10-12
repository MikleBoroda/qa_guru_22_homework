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

        registrationPage.checkResult("Student Name", "Mixa Smith")
                .checkResult("Student Email", "test@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9991112233")
                .checkResult("Date of Birth", "08 September,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading")
                .checkResult("Address", "Vladimir city")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }
}
