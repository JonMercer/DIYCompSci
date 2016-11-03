package coding_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-11-02.
 */
public class GRepeatingCharacterImplTest {

    GRepeatingCharacter r;
    @Before
    public void setUp() throws Exception {
        r = new GRepeatingCharacterImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void firstRepeatingCharacter() throws Exception {
        assertEquals(' ', r.firstRepeatingCharacter(""));
        assertEquals('a', r.firstRepeatingCharacter("aa"));
        assertEquals('a', r.firstRepeatingCharacter("bacab"));
        assertEquals(' ', r.firstRepeatingCharacter("hi"));
    }

}