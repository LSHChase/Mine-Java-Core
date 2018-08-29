package chapter;/*
 * ------------------------------------------------------------------
 * Copyright © 2018 DtDream Scien ce and Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *       Product: ASR
 *   Module Name: web
 *  Date Created: 2018-06-09
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018-06-09      sx-9524
 * ------------------------------------------------------------------
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChapterSeven {
    public void useFunction() {
//        useExceptionStackTrace();
//        useAssert();
        try{
            useLog();
        }catch (IOException e){
            myLogger.info("useFunction.log.throw");
        }
    }

    public void useExceptionStackTrace() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        factorial(n);
    }

    public static int factorial(int n) {
        System.out.println("factorial (" + n + "): ");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames)
            System.out.println(f);
        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }

    public void useAssert() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input number: ");
        int num = in.nextInt();
        double sq = 0;
        assert num >= 0 : "number >= 0";
        sq = Math.sqrt(num);
        System.out.println("sqrt(" + num + ") = " + sq);

        if (num % 3 == 0)
            System.out.println(num + " % 3 = 0");
        else if (num % 3 == 1)
            System.out.println(num + " % 3 = 1");
        else {
            assert num % 3 == 2 : num + " is error!";
            System.out.println(num + " % 3 = 2");
        }
    }

    //企业级日志
    private static final Logger myLogger = Logger.getLogger("com.me.demo.InOutPut");

    public void useLog() throws IOException{
//        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("简单日志");
        myLogger.setLevel(Level.INFO);
        myLogger.log(Level.INFO, "企业级日志");

        myLogger.entering("com.demo.InOutPut.chapter", "ChapterSeven", "entering");
        IOException exception = new IOException("log.throwing");
        myLogger.throwing("com.me.demo.InOutPut", "throw", exception);
        throw exception;

    }
}
