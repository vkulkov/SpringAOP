package com.springinaction;

import com.springinaction.springidol.Contestant;
import com.springinaction.springidol.Performer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("aspects.xml")
public class AspectTest {
    @Inject
    private ApplicationContext context;

    @Test
    public void audienceShouldApplaud() {
        Performer duke = (Performer) context.getBean("duke");
        duke.perform();
    }

    @Test
    public void dukeShouldBeContestant() {
        Contestant duke = (Contestant) context.getBean("duke");
        duke.receiveAward();
    }
}
