package chapter;

import office.Employee;
import office.Manager;
import strings.LengthComparator;
import time.TimePrinter;

import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

public class Six {
    public void function() {
//        this.useSort();
//        this.useDate();
        this.useClone();
    }

    public void useSort() {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("张三", 20000, 1999, 5, 17);
        staff[1] = new Employee("李四", 15000, 1994, 3, 16);
        staff[2] = new Employee("王五", 12000, 2001, 9, 3);

        Manager manager = new Manager("赵六", 50000, 1992, 7, 13);
        manager.setBonus(5000);
        staff[3] = manager;

        Arrays.sort(staff);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ", position = " + e.getClass().getName() + ", salary = " + e.getSalary());

        //Comparator 接口
        String[] friends = {"Peter", "Paul", "Mary"};
        Arrays.sort(friends, new LengthComparator());
//        Arrays.sort(friends);
        for (String str : friends)
            System.out.println(str + ", ");
    }

    public void useDate() {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    public void useClone() {
        Employee employee = new Employee("张三", 12000, 1999, 6, 15);
        Employee copyEmp = employee;
        copyEmp.raiseSalary(10);
        System.out.println(employee.getName() + "'s salary is " + employee.getSalary() + "\n" +
                copyEmp.getName() + "'s salary is " + copyEmp.getSalary());
        try {
            Employee cloneEmp = employee.clone();
            cloneEmp.raiseSalary(10);
            System.out.println(employee.getName() + "'s salary is " + employee.getSalary() + "\n" +
                    cloneEmp.getName() + "'s salary is " + cloneEmp.getSalary());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
