package datapages;

public enum Subject {
    ARTS("Arts"),
    ACCOUNTING("Accounting"),
    HISTORY("History");

    public String description;

    Subject(String description) {
        this.description = description;
    }
}
