package chapter;

import E_enum.Size;
import abstractClasses.Person;
import office.*;
import reflection.ReflectionTest;
import schools.Student;

import java.lang.reflect.Modifier;
import java.util.*;

public class ChapterFifth {

    public void useFunction(){
        //this.useMana();
        //this.useObject();
        //this.useHashCode();
        //this.useToString();
        //this.useArrayList();
        //this.useWrapper();
        //this.useVariPara();
        //this.useEnum();
       // this.useReflect();
        //this.analysisClass();
    }

    //Manager
    public void useMana(){
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for (Employee e : staff)
            System.out.println(e.getName()+" : "+e.getSalary());

        //类型转换前查看是否能够成功转换
        if (staff[1] instanceof Manager){
            Manager bos = (Manager) staff[1];
        }

        Person[] people = new Person[2];
        people[0] = new Employee("张三",10000,2000,2,4);
        people[1] = new Student("李四","Computer Tester");

        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }

    //Use Object.equals
    public void useObject(){
        Object obj = new Employee("Tom",35000,2002, 2 , 3);
        Employee e = (Employee) obj;

        //Object.equals(), 如果两个对象引用相同，它们一定相等
        if (e.equals(obj))
            System.out.println("They are the same!");
        else
            System.out.println("They are different!");
    }

    //Use Object.hashCode
    public void useHashCode(){
        String s = "Ok";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + ", " + sb.hashCode());
        String t = new String("Ok");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + ", " + tb.hashCode());

        //Equals 与 hashCode 的定义必须相同
        Object obj = new Employee("Tom",35000,2002, 2 , 3);
        Employee e = (Employee) obj;

        if (e.hashCode() == obj.hashCode())
            System.out.println("Their hashCodes are the same! ," + e.hashCode());
        else
            System.out.println("Their hashCodes are different! ," + e.hashCode() + obj.hashCode());
    }

    //Use Object.toString
    public void useToString(){
        Object obj = new Employee("Tom",35000,2002, 2 , 3);
        Manager manager = new Manager("Jack" , 100000, 2003, 8, 7);
        manager.setBonus(5000);

        System.out.println(obj.toString());
        System.out.println(manager.toString());

        System.out.println(System.out);

        int[][] deepArr = {{1,2,3},{4,5,6},{7,8,9}};
        String s = "" + deepArr;
        System.out.println(s);
        System.out.println(Arrays.toString(deepArr));
        System.out.println(Arrays.deepToString(deepArr));
    }

    //Use ArrayList--泛型数组列表
    public void useArrayList(){
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker", 80000, 1987, 12, 15));
        staff.add(new Employee("张三",10000,2000,2,4));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        staff.ensureCapacity(100);
        System.out.println("This ArrayList has " + staff.size() + " staffs!");
        for (Employee e : staff)
            System.out.println(e.toString());
        System.out.println("\n--------------------------------------------------------------------------------------\n");

        Employee employee = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff.set(1,employee);
        for (Employee e : staff)
            System.out.println(e.toString());
        System.out.println("\n--------------------------------------------------------------------------------------\n");
        System.out.println(staff.get(0).toString());
        System.out.println("\n--------------------------------------------------------------------------------------\n");

        Employee emp = new Employee("张三",10000,2000,2,4);

        staff.add(staff.size(),emp);
        Employee[] staffCpy = new Employee[staff.size()];
        staff.toArray(staffCpy);
        for (Employee e : staffCpy)
            System.out.println(e.toString());
        System.out.println("\n--------------------------------------------------------------------------------------\n");
        staff.remove(1);
        for (Employee e : staff)
            System.out.println(e.toString());
        System.out.println("\n--------------------------------------------------------------------------------------\n");

    }

    //对象包器装与自动装箱测试
    public void useWrapper(){
       // ArrayList<int> list = new ArrayList<>();基本类型不可用于<>中
        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);//等价于list.add(Integer.valueOf(3));--自动装箱
        int n = list.get(0);//等价于list.get(0).intValue();--自动拆箱
        System.out.println("n = " + n);

        Integer integer1 = 100;
        Integer integer2 = 100;
        //一般不能判定相等，除非包装到同一个对象中
        if (integer1 == integer2)
            System.out.println("The two Integers are the same !");
        else
            System.out.println("The two Integers are different !");

        Integer integer3 = 10;
        Double dou = 2.0;
        //混合使用Integer和Double,Integer就会自动拆箱，提升为double，然后装箱为Double
        System.out.println(true ? integer3 : dou);

        String str = "123456789";
        int strNum = Integer.parseInt(str);
        System.out.println(str + " is " + strNum);

    }

    //参数数量可变的方法
    public void useVariPara(){
        int n = 10;
        System.out.printf("%d---%s \n", new Object[] { new Integer(n), "widgets"});

        System.out.println("max = " + max(1.1, 2.1,3.6,1.0,0.5,0.75,46,10.8,17.2,5.1));
    }
    public static double max (double... values){
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : values)
            if (v > largest)
                largest = v;
        return largest;

    }

    //Use enum
    public void useEnum(){
        System.out.println(Size.SMALL.toString());

        Size size = Enum.valueOf(Size.class, "SMALL");
        System.out.println("SMALL is " + size.getAbbreviation());

        Size[] values = Size.values();
        for (Size s : values)
            System.out.println(s.toString() + " = " + s.getAbbreviation() + " is in the " + s.ordinal());
    }

    //Use reflection
    public void useReflect(){
        Employee staff = new Employee("张三", 15000, 2000, 10, 7);
        Manager manager = new Manager("李四", 50000, 1998, 12, 16);
        manager.setBonus(10000);

        //getClass(), getName(), forName()
        System.out.println(staff.getClass().getName() + "--" + staff.getName());
        System.out.println(manager.getClass().getName() + "--" + manager.getName());
        try {
            String className = "java.util.Random";
            Class c1 = Class.forName(className);
            System.out.println(c1.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //getClass() 与 .class
        Class cl1 = Random.class;
        Class cl2 = int.class;
        Class cl3 = Double[].class;
        System.out.println(cl1.getName() + ", " + cl2.getName() + ", " + cl3.getName() + ", " + int[].class.getName());
        if (staff.getClass() == Employee.class)
            System.out.println("It is right!");
        else
            System.out.println("It is wrong!");
//        try {
//            Employee employee = staff.getClass().newInstance();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

        //Analysis class----------------------It is important!!!
        this.analysisClass();
    }
    public void analysisClass(){
        String name;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter class name (e.g. java.util.Date)");
        name = in.next();
        try {
            //print class name and superclass name (if != Object)
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (superCl != null && superCl != Object.class) System.out.print(" extends " + superCl.getName());

            System.out.print("\n{\n");
            ReflectionTest.printConstructors(cl);
            System.out.println();
            ReflectionTest.printMethods(cl);
            System.out.println();
            ReflectionTest.printFields(cl);
            System.out.println("}");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
