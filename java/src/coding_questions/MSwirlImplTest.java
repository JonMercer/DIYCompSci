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
    MSwirl m2;
    @Before
    public void setUp() throws Exception {
        m = new MSwirlImpl();
        m2 = new MSwirlImpl2();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void swirl() throws Exception {
        assertEquals("a", m.swirl(new char[][]{{'a'}}));
        assertEquals("abdc", m.swirl(new char[][]{{'a', 'c'}, {'b', 'd'}}));
        assertEquals("aaaaabbbbccccdddeeeffgghi", m.swirl(new char[][]{{'a', 'd', 'd', 'd', 'c'}, {'a', 'e', 'h', 'g', 'c'}, {'a', 'e', 'i', 'g', 'c'}, {'a', 'e', 'f', 'f', 'c'}, {'a', 'b', 'b', 'b', 'b'}}));
    }

    @Test
    public void swirl2() throws Exception {
        assertEquals("a", m2.swirl(new char[][]{{'a'}}));
        assertEquals("abdc", m2.swirl(new char[][]{{'a', 'c'}, {'b', 'd'}}));
        assertEquals("aaaaabbbbccccdddeeeffgghi", m2.swirl(new char[][]{{'a', 'd', 'd', 'd', 'c'}, {'a', 'e', 'h', 'g', 'c'}, {'a', 'e', 'i', 'g', 'c'}, {'a', 'e', 'f', 'f', 'c'}, {'a', 'b', 'b', 'b', 'b'}}));
    }

    @Test
    public void rotate180() throws Exception {
        char[][] before = new char[][]{{'a', 'c'}, {'b', 'd'}};
        char[][] after = ((MSwirlImpl2) m2).rotate180(before);
        char[][] sol = new char[][]{{'d', 'b'}, {'c', 'a'}};

        int length = sol.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                assertEquals(sol[i][j], after[i][j]);
            }
        }
    }

}