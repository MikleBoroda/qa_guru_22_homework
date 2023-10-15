package utils;

import com.github.javafaker.Faker;
import datapages.Gender;
import datapages.Hobbie;
import datapages.State;
import datapages.Subject;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class RandomUtils {
    public Faker faker = new Faker(new Locale("en"));

    public String randomFirstName() {
        return faker.name().firstName();
    }

    public String randomLastName() {
        return faker.name().lastName();
    }

    public String randomEmail() {
        return faker.internet().emailAddress();
    }

    public Gender randomGender() {
        return faker.options().option(Gender.values());
    }

    public String randomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public Subject randomSubject() {
        return faker.options().option(Subject.values());
    }

    public Hobbie randomHobbie() {
        return faker.options().option(Hobbie.values());
    }

    public String randomDay() {
        int day = new Random().nextInt(27) + 1;
        return day < 10 ? "0" + day : String.valueOf(day);
    }

    public String randomMonth() {
        LocalDate localDate = LocalDate.of(2023, new Random().nextInt(11) + 1, 1);
        String month = localDate.getMonth().toString();
        return month.substring(0, 1) + month.substring(1).toLowerCase();
    }

    public String randomYear() {
        int min = 1900;
        int max = 2100;
        int diff = max - min;
        Random random = new Random();
        int year = random.nextInt(diff + 1) + min;
        return String.valueOf(year);
    }

    public String randomCurrentAddress() {
        return faker.address().fullAddress();
    }

    public State randomStateCity() {
        return faker.options().option(State.values());
    }
}
