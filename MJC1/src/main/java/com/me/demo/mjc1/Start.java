package com.me.demo.mjc1;

import com.me.demo.mjc1.chapter.*;

public class Start{

    public static void main(String[] args) {
//        boolean cycle = true;
//        boolean listCysle = true;

//        while (cycle){
//            if (listCysle) {
//                ArrayList<String> list = new ArrayList<>();
//                list.add("1.Chapter 3: !");
//                list.add("2.Chapter 4: !");
//                list.add("3.Chapter 5: !");
//                list.add("5.Chapter 6: !");
//                list.add("5.Chapter 7: !");
//                list.add("6.Chapter 8: !");
//                for (String chapter : list) {
//                    System.out.println(chapter);
//                }
//            }
//
//            Scanner in = new Scanner(System.in);
//            int select = 0;
//            System.out.println("Please select chapter: ");
//            select = in.nextInt();
            switch (9){
                case 0:
//                    cycle = false;
                    break;
                case 3:
                    Three third = new Three();
                    third.function();
                    break;
                case 4:
                    Four forth = new Four();
                    forth.function();
                    break;
                case 5:
                    Five fifth = new Five();
                    fifth.function();
                    break;
                case 6:
                    Six sixth = new Six();
                    sixth.function();
                    break;
                case 7:
                    Seven seven = new Seven();
                    seven.function();
                    break;
                case 8:
                    Eight eight = new Eight();
                    eight.function();
                    break;
                case 9:
                    Nine nine = new Nine();
                    nine.function();
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
