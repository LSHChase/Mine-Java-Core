package main;

import chapter.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String args[]) {
//        boolean cycle = true;
//        boolean listCysle = true;

//        while (cycle){
//            if (listCysle) {
                ArrayList<String> list = new ArrayList<>();
                list.add("1.Chapter 3: !");
                list.add("2.Chapter 4: !");
                list.add("3.Chapter 5: !");
                list.add("5.Chapter 6: !");
                list.add("5.Chapter 7: !");
                list.add("6.Chapter 8: !");
                for (String chapter : list) {
                    System.out.println(chapter);
                }
//            }

            Scanner in = new Scanner(System.in);
            int select = 0;
            System.out.println("Please select chapter: ");
            select = in.nextInt();
            switch (select){
                case 0:
//                    cycle = false;
                    break;
                case 1:
                    Three third = new Three();
                    third.function();
                    break;
                case 2:
                    Four forth = new Four();
                    forth.function();
                    break;
                case 3:
                    Five fifth = new Five();
                    fifth.function();
                    break;
                case 4:
                    Six sixth = new Six();
                    sixth.function();
                    break;
                case 5:
                    Seven seven = new Seven();
                    seven.function();
                    break;
                case 6:
                    Eight eight = new Eight();
                    eight.function();
                    break;
                default:
                    System.out.println("This Chapter does not exit!");
                    break;

            }

//            System.out.println("Do you want to display the list again? \n1.是.\n2.否");
//            switch (in.nextInt()){
//                case 1:
//                    listCysle = true;
//                    break;
//                case 2:
//                    listCysle = false;
//                    break;
//                    default:
//                        System.out.println("Your input is error!");
//                        break;
//            }

//        }
    }
}
