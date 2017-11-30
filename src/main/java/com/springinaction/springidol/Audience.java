package com.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

    public void takeSeats(){
        System.out.println("The audience is taking their seats");
    }

    public void turnOffCellPhones(){
        System.out.println("the audience is turning off their cellphones");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("The performance took: " + (end - start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public void applaud(){
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    public void demandRefund(){
        System.out.println("Boo! We want our money back!");
    }
}
