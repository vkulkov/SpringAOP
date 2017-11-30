package com.springinaction.annotations;

import com.springinaction.general.Contestant;
import com.springinaction.general.GraciousContestant;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

    @DeclareParents(value = "com.springinaction.general.Performer+", defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
