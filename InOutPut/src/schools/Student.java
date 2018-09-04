package schools;

import abstractclas.AbstractPerson;

public class Student extends AbstractPerson {

    private String major;

    /**
     * @param name AbstractPerson's name
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
