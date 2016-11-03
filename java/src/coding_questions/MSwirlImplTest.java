package coding_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-11-02.
 */
public class MSwirlImplTest {
    MSwirl m;
    @Before
    public void setUp() throws Exception {
        m = new MSwirlImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void swirl() throws Exception {
        assertEquals("a", m.swirl(new char[][]{{'a'}}));
        assertEquals("abdc", m.swirl(new char[][]{{'a', 'c'}, {'b', 'd'}}));
        assertEquals("abcdhlkjiefg", m.swirl(new char[][]{{'a', 'e', 'i'}, {'b', 'f', 'j'}, {'c', 'g', 'k'}, {'d', 'h', 'l'}}));
        assertEquals("aaaaabbbbccccdddeeeffgghi", m.swirl(new char[][]{{'a', 'd', 'd', 'd', 'c'}, {'a', 'e', 'h', 'g', 'c'}, {'a', 'e', 'i', 'g', 'c'}, {'a', 'e', 'f', 'f', 'c'}, {'a', 'b', 'b', 'b', 'b'}}));

    }

}