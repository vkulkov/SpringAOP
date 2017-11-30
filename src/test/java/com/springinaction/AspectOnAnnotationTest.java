package com.springinaction;

import com.springinaction.general.Contestant;
import com.springinaction.general.MindReader;
import com.springinaction.general.Performer;
import com.springinaction.general.Thinker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"aspects-annotations.xml"})
public class AspectOnAnnotationTest {
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

    @Test
    public void magicianShouldReadVolunteerMind() {
        MindReader magician = (MindReader) context.getBean("magician");
        Thinker volunteer = (Thinker) context.getBean("volunteer");

        volunteer.thinkOfSomething("Queen of Hearts");

        assertEquals(volunteer.getThoughts(), magician.getThoughts());
    }
}
