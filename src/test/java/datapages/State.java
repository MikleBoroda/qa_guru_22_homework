package datapages;

import com.github.javafaker.Faker;

public enum State {
    NCR("NCR") {
        public String city() {
            Faker faker = new Faker();
            String[] city = new String[]{"Delhi", "Gurgaon", "Noida"};
            return faker.options().option(city);
        }
    },
    UTTAR_PRADESH("Uttar Pradesh") {
        public String city() {
            Faker faker = new Faker();
            String[] city = new String[]{"Agra", "Lucknow", "Merrut"};
            return faker.options().option(city);
        }

    },
    HARYANA("Haryana") {
        public String city() {
            Faker faker = new Faker();
            String[] city = new String[]{"Karnal", "Panipat"};
            return faker.options().option(city);
        }
    },
    RAJASTHAN("Rajasthan") {
        public String city() {
            Faker faker = new Faker();
            String[] city = new String[]{"Jaipur", "Jaiselmer"};
            return faker.options().option(city);
        }

    };

    public String description;

    State(String description) {
        this.description = description;
    }

    public abstract String city();
}