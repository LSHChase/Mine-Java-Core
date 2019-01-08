package com.me.demo.mjc1.entity.office;

public final class Executive extends Manager {

    /**
     * @param name manager's name
     * @param salary ... salary
     * @param year ... year
     * @param month ...month
     * @param day ... day
     */
    public Executive(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        super.setBonus(10000);
    }
}
