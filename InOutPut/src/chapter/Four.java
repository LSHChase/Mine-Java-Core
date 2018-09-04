package chapter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import office.*;

public class Four {

    public static final double PI = 3.14159265358979323846;

    public void function(){

        //this.dateDefault();
        //this.localDate();
        this.useEmp();
        //this.staticTest();
    }

    //Date default class
    public void  dateDefault(){
        Date date = new Date();
        String s = date.toString();
        System.out.println(s);

        Date date1 = null;
        if (date1 != null)
            System.out.println(date1.toString());
        date1 = date;
        System.out.println(date1.toString());
    }

    //LocalDate default class
    public void localDate(){
        //We should use factory method(静态工厂方法) instead of using constructor
        System.out.println(LocalDate.now());

        LocalDate newYearsEve = LocalDate.of(2000, 1,1);
        int year = newYearsEve.getYear();
        int month = newYearsEve.getMonthValue();
        int day = newYearsEve.getDayOfMonth();
        System.out.println(newYearsEve);
        System.out.println(day+", "+month+", "+year);
        System.out.println("---------------------------------------------------------------------------");

        //LocalDate's plusDays() doesn't change newYearsEve
        LocalDate plusYearEve = newYearsEve.plusDays(1000);
        year = plusYearEve.getYear();
        month = plusYearEve.getMonthValue();
        day = plusYearEve.getDayOfMonth();
        System.out.println(newYearsEve);
        System.out.println(plusYearEve);
        System.out.println(day+", "+month+", "+year);
        System.out.println("---------------------------------------------------------------------------");

        //GregorianCalendar's add() changes someDay
        GregorianCalendar someDay = new GregorianCalendar(1999,11,31);
        year = someDay.get(Calendar.YEAR);
        month = someDay.get(Calendar.MONTH);
        day = someDay.get(Calendar.DAY_OF_MONTH);
        System.out.println(day+", "+month+", "+year);
        someDay.add(Calendar.DAY_OF_MONTH,1000);
        year = someDay.get(Calendar.YEAR);
        month = someDay.get(Calendar.MONTH);
        day = someDay.get(Calendar.DAY_OF_MONTH);
        System.out.println(day+", "+month+", "+year);
        System.out.println("---------------------------------------------------------------------------");

        //Print Calendar
        LocalDate date = LocalDate.now();
        month = date.getMonthValue();
        day = date.getDayOfMonth();
        date = date.minusDays(day - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1;i < value; i++) {
            System.out.print("    ");
        }

        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth() == day)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1)
                System.out.println();
        }

    }

    //Use Employee class
    public void useEmp(){


        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ",salary = " + e.getSalary() + ",hireDay = " + e.getHireDay()
                    + ",Date.clone = " + e.getHireDayClone());

        if (staff[0].equals(staff[2]))
            System.out.println("Their names are same!");
        else
            System.out.println("Their names are different!");

        //设置id
//        staff[0].setId();
//        staff[1].setId();
//        staff[2].setId();

        for (Employee e : staff)
            System.out.println("staff.id = "+e.getId());

        int n = Employee.getNextId();
        System.out.println("The nextId is " + n + " !");
    }

    //Test static Math
    public void staticTest(){
        double s = 3*3*PI;
        System.out.println("The s is " + s + "!");

        int x = 3;
        int a = 3;
        System.out.println("x^a = " + Math.pow(x , a));
    }
}
