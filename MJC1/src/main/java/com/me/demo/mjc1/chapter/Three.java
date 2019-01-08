package com.me.demo.mjc1.chapter;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Three extends IOException{

    private Scanner in = new Scanner(System.in);

    public void function(){

        this .inputScanner();
        System.out.println("--------------------------------------------------------------------");
        //third.inputConsole();
        this.inputFile();
        System.out.println("--------------------------------------------------------------------");
        this.outputFormatted();
        System.out.println("--------------------------------------------------------------------");
        this.printfDate();
        System.out.println("--------------------------------------------------------------------");
        this.forEachAndArrays();
        System.out.println("--------------------------------------------------------------------");
        this.breakLabel();
        System.out.println("--------------------------------------------------------------------");
        this.bigInt();
        System.out.println("--------------------------------------------------------------------");
        this.arrySort();
        System.out.println("--------------------------------------------------------------------");
        this.sortRandom();
        System.out.println("\n--------------------------------------------------------------------");
        this.compoundInterest();
        System.out.println("--------------------------------------------------------------------");
        this.lotteryArray();
        System.out.println("--------------------------------------------------------------------");
    }

    //Input from keyboards
    public void inputScanner (){

        System.out.println("Hello Intellij IDEA! Please input your information:");
        //Get a line's Strings
        System.out.println("What is your name?");
        String name = in.nextLine();

        //Get a number
        System.out.println("How old are you?");
        int age = in.nextInt();

        //Get a word
        System.out.println("What kind of fruits would you like?");
        String fruit = in.next();

        //Display your information
        System.out.println("Name: " + name + "\n" + "Age: " + age + "\n" + "Like fruit: " + fruit);
        System.out.println("Thanks!");
    }

    //Input username and password
    public void inputConsole(){

        //Get user_name and password from a ui
        Console cons =System.console();
        String userName = cons.readLine("User name:");
        char[] password = cons.readPassword("Password:");

        System.out.println("User name: "+userName+"\n"+"Password: "+password);
    }

    //Input from file
    public void inputFile(){
        //Get file
        try {
            Scanner inFile = new Scanner(Paths.get("demoGet.txt"), "UTF-8");
            String fileText = inFile.nextLine();
            System.out.println(fileText);

            PrintWriter out = new PrintWriter("demoPut.txt","UTF-8");
            String outStr = "This is outWrite file text!";
            out.write(outStr);
        }
        catch (IOException e){

        }
    }

    //格式化输出
    public void outputFormatted (){

        System.out.printf("10000/3 = %8.2f \n", 10000.0 / 3.0);
        System.out.printf("10000/3 = %,.2f \n", 10000.0 / 3.0);
        System.out.printf("-10000/3 = %,(.2f \n",-10000.0 / 3.0);
    }

    //printf()打印日期，以t开始
    public void printfDate(){

        System.out.println("以下是日期：");
        System.out.printf("Tc is %tc \n",new Date());
        System.out.printf("TF is %tF \n",new Date());
        System.out.printf("TD is %tD \n",new Date());
        System.out.printf("TT is %tT \n",new Date());
        System.out.printf("%1$s %2$tB %2$te, %2$tY\n","Due date:",new Date());
        System.out.printf("%s %tB %<te, %<tY\n","Due date:",new Date());
    }

    //for each and Arrays.toString and Arrays.copyOf
    public void forEachAndArrays(){

        int[] a = new int[10];
        for (int i=0;i<a.length;i++){
            a[i]=i*2+1;
        }
        for (int element: a){
            System.out.println(element);
        }
        System.out.println(Arrays.toString(a));

        //Arrays.copyOf(),copy a arrays to others
        int[] copyA = Arrays.copyOf(a,a.length);
        System.out.println(Arrays.toString(copyA));
        copyA = Arrays.copyOf(copyA,copyA.length+3);
        System.out.println(copyA);
    }

    //Label
    public void breakLabel(){

        int i = 0;
        label:{
            System.out.println("Please input number:");
            i = in.nextInt();
            if(0 == i) break label;
            System.out.println("You input a "+i);
        }
        System.out.println("The number is "+i);
    }

    //BigIntegerTest
    public void bigInt(){

        System.out.println("How many numbers do you need to draw? (k) ");
        int k = in.nextInt();
        System.out.println("What is the highest number you can draw? (n) ");
        int n = in.nextInt();
        /*
         * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
         */
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i < k; i++){
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("Your odds are 1 in " + lotteryOdds +".Good Luck!");
    }

    //Arrays.sort(a)------Quick sort
    public void arrySort(){
        int[] a = {5,5,9,16,4,7,8,9,5,4,2,5,99,2,24,1,58,5,66,4626,2,3,492,9,41,59,24,19,629,16,4};
        System.out.println("Without sort: "+Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Sorted: "+Arrays.toString(a));
    }

    //Extract random numbers and sort
    public void sortRandom(){
        System.out.println("How many numbers do you need to draw? (k)");
        int k = in.nextInt();
        System.out.println("What is the highest number you can draw? (n)");
        int n = in.nextInt();

        //Fill an areay with 1,2,3,...,n
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = i+1;
        }

        //Draw k numbers and put them into a second array
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++){
            //Make a random index between 0 and n-1
            int r = (int) (Math.random()*n);

            //Pick the element at the random location
            result[i] = numbers[r];

            //Move the last element into the random location
            numbers[r] = numbers[n-1];
            n--;
        }

        System.out.println("Without sort: \n"+Arrays.toString(result));

        //Sort and print array
        Arrays.sort(result);
        System.out.println("Sort: ");
        for (int r : result){
            System.out.print(r+" ");
        }
    }

    //Multidimensional Arrays
    public void compoundInterest(){
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        //Set interest rates to 10 ... 15%
        double[] interestRate = new double[NRATES];
        for (int j = 0;j < interestRate.length; j++){
            interestRate[j] = (STARTRATE + j) / 100.0;
        }

        double[][] balances = new double[NYEARS][NRATES];

        //Set initial balances to 10000
        for (int j = 0;j < balances[0].length; j++){
            balances[0][j] = 10000;
        }

        //Compute interest for future years
        for (int i = 1;i < balances.length; i++){
            for (int j =0;j < balances[i].length; j++){
                //Get last year's balance from previous row
                double oldBalance = balances[i - 1][j];

                //Compute interest
                double interest = oldBalance*interestRate[j];

                //Compute this year's balances
                balances[i][j] = oldBalance + interest;
            }
        }

        //Print one row of interest rates
        for (int j = 0;j < interestRate.length; j++){
            System.out.printf("%9.0f%%",100*interestRate[j]);
        }
        System.out.println();

        //Print balance table
        for (double[] row: balances){
            //Print table row
            for (double b : row){
                System.out.printf("%10.2f",b);
            }
            System.out.println();
        }
    }

    //Irregular array
    public void lotteryArray(){
        int max = 0;
        System.out.println("Please input max row,Thanks!");
        max = in.nextInt();

        //Allocate triangular array
        int[][] odds = new int[max][];
        for (int n = 0;n < max; n++){
            odds[n] = new int[n+1];
        }

        //Fill triangular array
        for (int n = 0;n < odds.length; n++){
            for (int k = 0;k < odds[n].length; k++){
                /*
                 * Compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
                 */
                int lotteryOdds = 1;
                for (int i = 1;i <= k; i++){
                    lotteryOdds = lotteryOdds * (n-i+1) / i;
                }

                odds[n][k] = lotteryOdds;
            }

            //Print triangular array
            for (int[] row : odds){
                for (int odd : row){
                    System.out.printf("%4d",odd);
                }
                System.out.println();
            }
        }
    }
}
