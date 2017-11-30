package com.springinaction;

import com.springinaction.springidol.MindReader;
import com.springinaction.springidol.Thinker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"aspects.xml"})
public class MindReaderTest {
    @Inject
    private MindReader magician;
    @Inject
    private Thinker volunteer;

    @Test
    public void magicianShouldReadVolunteerMind() {
        volunteer.thinkOfSomething("Queen of Hearts");

        assertEquals(volunteer.getThoughts(), magician.getThoughts());
    }
}
