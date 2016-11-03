package coding_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-11-02.
 */
public class JAnagramImplTest {
    JAnagram j;

    @Before
    public void setUp() throws Exception {
        j = new JAnagramImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void anagram() throws Exception {
        assertTrue(j.anagram("dogs", "gods"));
        assertFalse(j.anagram("dogss", "gods"));
        assertTrue(j.anagram("", ""));
        assertTrue(j.anagram("aaaa", "aaaa"));
    }

}