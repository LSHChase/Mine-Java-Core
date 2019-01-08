package com.me.demo.mjc1.entity.office;

public class Manager extends Employee {

    private double bonus;

    /**
     * @param name   the employ's name
     * @param salary ... the salary
     * @param year   ... the year
     * @param month  ... the month
     * @param day    ... the day
     */

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        //super.equals checked that this and otherObject belong to the same class
        Manager other = (Manager) obj;
        return bonus == ((Manager) obj).bonus;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * Double.hashCode(bonus);
    }

    @Override
    public String toString() {
        return super.toString() + ", [ bonus = " + bonus + " ]";
    }

}
