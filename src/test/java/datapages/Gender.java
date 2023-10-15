package datapages;

public enum Gender {
    MALE("Male"),
    FEMAIL("Female"),
    OTHER("Other");

    public String description;

    Gender(String description) {
        this.description = description;
    }
}
