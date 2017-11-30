package com.springinaction.annotations;

import com.springinaction.general.MindReader;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.springinaction.general.Thinker.thinkOfSomething(..)) && args(thoughts)")
    public void thinking(String thoughts) {}

    @Override
    @Before("thinking(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
