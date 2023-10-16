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

        checkComponent.checkResultTextBoxPage("Name:", "Mikle Smith")
                .checkResultTextBoxPage("Email:", "Mikle@nail.ru")
                .checkResultTextBoxPage("Permananet Address :", "Moscow");
    }
}
