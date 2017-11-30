package com.springinaction.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* com.springinaction.general.Performer.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void takeSeats(){
        System.out.println("The audience is taking their seats");
    }

    @Before("performance()")
    public void turnOffCellPhones(){
        System.out.println("the audience is turning off their cellphones");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("The performance took: " + (end - start));
        } catch (Throwable throwable) {
            throw new Throwable(throwable);
        }
    }

    @AfterReturning("performance()")
    public void applaud(){
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Boo! We want our money back!");
    }
}
