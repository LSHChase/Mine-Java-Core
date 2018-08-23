package schools;

import abstractClasses.Person;

public class Student extends Person {

    private String major;

    /**
     * @param name Person's name
     * @param major Student's major
     */
    public Student(String name, String major){
        super(name);
        this.major = major;
    }
    @Override
    public String getDescription() {
        return "A student majoring " + major;
    }
}
