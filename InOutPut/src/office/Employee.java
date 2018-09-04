package office;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import abstractclas.AbstractPerson;

public class Employee extends AbstractPerson implements Comparable<Employee>, Cloneable {
    //Instance fields
    //private String name;
    private double salary;
    private LocalDate hireDay;
    private java.sql.Date hireDaySql;
    private java.util.Date hireDayUtil;
    private static int nextId = 001;
    private int id;

    //constructor
    public Employee(String aName, double aSalary, int year, int month, int day) {
        super(aName);
        this.salary = aSalary;
        this.hireDay = LocalDate.of(year, month, day);
        this.hireDaySql = Date.valueOf(hireDay);
        this.hireDayUtil = hireDaySql;
        this.setId();
    }

    //Methods

//    public String getName() {
//        return this.getName();
//    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public java.util.Date getHireDayUtil() {
        return hireDayUtil;
    }

    //对象clone
    public Date getHireDayClone() {
        return (Date) hireDaySql.clone();
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Employee other) {
        return this.getName().equals(other.getName());
    }

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String getDescription() {
        return String.format("An employee with a salary of $%.2f", salary);
    }

    @Override
    public boolean equals(Object obj) {
        //A quick test to see if the objects are identical
        if (this == obj) return true;

        //Must return false if the explicit parameter is null
        if (obj == null) return false;

        ////If the classes don't match, they can't be equal
        if (getClass() != obj.getClass()) return false;

        //Now we know object is a non-null Employee
        Employee other = (Employee) obj;

        //Test whether the fields have identical values
        return Objects.equals(getName(), other.getName())
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    @Override
    //重新定义equals就得重新定义hashCode
    public int hashCode() {

        // return 7 * getName().hashCode() + 11 * new Double(salary).hashCode() + 13 * hireDay.hashCode();
        //return 7 * Objects.hashCode(getName()) + 11 * Double.hashCode(salary) + 13 * Objects.hashCode(hireDay);
        return Objects.hash(getName(), salary, hireDay);
    }

    @Override
    public String toString() {

        //return "Employee[name=" + getName() + ", salary=" + salary + ", hireDay" + hireDay + "]";
        return getClass().getName() + "[ name = " + getName() + ", salary = " + salary + ", hireDay = " + hireDay + " ]";
    }

    @Override
    public final int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();

        cloned.hireDayUtil = (Date) hireDayUtil.clone();
        cloned.hireDaySql = (Date) hireDaySql.clone();
        return cloned;
    }
}
