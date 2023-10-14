package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    public Faker faker = new Faker(new Locale("en"));

    public String randomFirstName() {
        return faker.name().firstName();
    }


}
