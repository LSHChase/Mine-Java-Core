package com.me.demo.mjc1.chapter;

import com.me.demo.mjc1.common.MyConstant;
import com.me.demo.mjc1.someclas.ImageViewerFrame;
import com.me.demo.mjc1.someclas.WindowsHandler;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Seven {
    public void function() {
//        useExceptionStackTrace();
//        useAssert();
        try{
            useLog();
//            useHandler();
        }catch (IOException e){
            myLogger.info("function.log.throw");
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
//        Logger.getGlobal().info("简单日志");
//        myLogger.setLevel(Level.INFO);
//        myLogger.log(Level.INFO, "企业级日志");
//
//        myLogger.entering("com.demo.InOutPut.chapter", "Seven", "entering");
//        IOException exception = new IOException("log.throwing");
//        myLogger.throwing("com.me.demo.InOutPut", "throw", exception);
//        throw exception;

        if (null == System.getProperty("java.util.logging.config.class")
                && null == System.getProperty("java.util.logging.config.file")){
            try{
                Logger.getLogger("com.me.demo").setLevel(Level.ALL);
                Handler handler = new FileHandler("%h/myapp.log", 0 , MyConstant.LOG_ROTATION_COUNT);
                Logger.getLogger("").addHandler(handler);
            }
            catch (IOException e){
                Logger.getLogger("com.me.demo").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }

        EventQueue.invokeLater(() ->{
            Handler windowHandler = new WindowsHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.me.demo").addHandler(windowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.me.demo").fine("Show frame");
            frame.setVisible(true);
        });

    }

    public void useHandler()throws FileNotFoundException {
        Logger logger = Logger.getLogger("com.me.demo");
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        logger.addHandler(handler);

        try {
            FileHandler fileHandler = new FileHandler();
            logger.addHandler(fileHandler);
        }
        catch(Exception e){

        }
    }
}
