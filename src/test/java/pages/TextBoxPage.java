package pages;

import com.codeborne.selenide.SelenideElement;
import ui_tests.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        TestBase.removeBanner();
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmit() {
        submitButton.click();
        return this;
    }
}
