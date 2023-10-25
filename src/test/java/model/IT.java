package model;

import java.util.List;
import java.util.Map;

public class IT {
    private String name;
    private int age;
    private String[] position;
    private List<String> skills;
    private Map<String, Long> salary;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getPosition() {
        return position;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Map<String, Long> getSalary() {
        return salary;
    }
}
