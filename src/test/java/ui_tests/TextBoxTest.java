package ui_tests;

import org.junit.jupiter.api.Test;



public class TextBoxTest extends TestBase {
    @Test
    void fillingTextBox() {
        textBoxPage.openPage()
                .setFullName("Mikle Smith")
                .setEmail("Mikle@nail.ru")
                .setCurrentAddress("Vladimir city")
                .setPermanentAddress("Moscow")
                .clickSubmit();

        textBoxPage.checkResult("Name:", "Mikle Smith")
                .checkResult("Email:", "Mikle@nail.ru")
                .checkResult("Permananet Address :", "Moscow");
    }
}
