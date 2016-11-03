package coding_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-11-02.
 */
public class MMovePatchImplTest {
    MMovePatch t;
    @Before
    public void setUp() throws Exception {
        t = new MMovePatchImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void patch2x2AtOrigin() throws Exception {
        //a 7x7 grid with origin at top left
        String[][] input = new String[][]{{"(0,0)", "(0,1)", "(0,2)", "(0,3)", "(0,4)", "(0,5)", "(0,6)"},{"(1,0)", "(1,1)", "(1,2)", "(1,3)", "(1,4)", "(1,5)", "(1,6)"},{"(2,0)", "(2,1)", "(2,2)", "(2,3)", "(2,4)", "(2,5)", "(2,6)"},{"(3,0)", "(3,1)", "(3,2)", "(3,3)", "(3,4)", "(3,5)", "(3,6)"},{"(4,0)", "(4,1)", "(4,2)", "(4,3)", "(4,4)", "(4,5)", "(4,6)"},{"(5,0)", "(5,1)", "(5,2)", "(5,3)", "(5,4)", "(5,5)", "(5,6)"},{"(6,0)", "(6,1)", "(6,2)", "(6,3)", "(6,4)", "(6,5)", "(6,6)"}};
        String[][] patch = t.patch(input, 0, 0, 2, 2);
        String[][] solution = new String[][]{{"(2,2)", "(2,3)", "(0,2)", "(0,3)", "(0,4)", "(0,5)", "(0,6)"},{"(3,2)", "(3,3)", "(1,2)", "(1,3)", "(1,4)", "(1,5)", "(1,6)"},{"(2,0)", "(2,1)", "(0,0)", "(0,1)", "(2,4)", "(2,5)", "(2,6)"},{"(3,0)", "(3,1)", "(1,0)", "(1,1)", "(3,4)", "(3,5)", "(3,6)"},{"(4,0)", "(4,1)", "(4,2)", "(4,3)", "(4,4)", "(4,5)", "(4,6)"},{"(5,0)", "(5,1)", "(5,2)", "(5,3)", "(5,4)", "(5,5)", "(5,6)"},{"(6,0)", "(6,1)", "(6,2)", "(6,3)", "(6,4)", "(6,5)", "(6,6)"}};
        assertEquals(Arrays.deepHashCode(solution), Arrays.deepHashCode(patch));
        isSame(solution, patch);
    }

    @Test
    public void patch3x3AtXis1andYis1() throws Exception {
        //a 7x7 grid with origin at top left
        String[][] input = new String[][]{{"(0,0)", "(0,1)", "(0,2)", "(0,3)", "(0,4)", "(0,5)", "(0,6)"}, {"(1,0)", "(1,1)", "(1,2)", "(1,3)", "(1,4)", "(1,5)", "(1,6)"}, {"(2,0)", "(2,1)", "(2,2)", "(2,3)", "(2,4)", "(2,5)", "(2,6)"}, {"(3,0)", "(3,1)", "(3,2)", "(3,3)", "(3,4)", "(3,5)", "(3,6)"}, {"(4,0)", "(4,1)", "(4,2)", "(4,3)", "(4,4)", "(4,5)", "(4,6)"}, {"(5,0)", "(5,1)", "(5,2)", "(5,3)", "(5,4)", "(5,5)", "(5,6)"}, {"(6,0)", "(6,1)", "(6,2)", "(6,3)", "(6,4)", "(6,5)", "(6,6)"}};
        String[][] patch = t.patch(input, 1, 1, 3, 3);
        String[][] solution = new String[][]{{"(0,0)", "(0,1)", "(0,2)", "(0,3)", "(0,4)", "(0,5)", "(0,6)"}, {"(1,0)", "(4,4)", "(4,5)", "(4,6)", "(1,4)", "(1,5)", "(1,6)"}, {"(2,0)", "(5,4)", "(5,5)", "(5,6)", "(2,4)", "(2,5)", "(2,6)"}, {"(3,0)", "(6,4)", "(6,5)", "(6,6)", "(3,4)", "(3,5)", "(3,6)"}, {"(4,0)", "(4,1)", "(4,2)", "(4,3)", "(1,1)", "(1,2)", "(1,3)"}, {"(5,0)", "(5,1)", "(5,2)", "(5,3)", "(2,1)", "(2,2)", "(2,3)"}, {"(6,0)", "(6,1)", "(6,2)", "(6,3)", "(3,1)", "(3,2)", "(3,3)"}};
        //assertEquals(Arrays.deepHashCode(solution), Arrays.deepHashCode(patch));
        isSame(solution, patch);
    }

    @Test
    public void patch3x1AtOrigin() throws Exception {
        //a 7x7 grid with origin at top left
        String[][] input = new String[][]{{"(0,0)", "(0,1)", "(0,2)", "(0,3)", "(0,4)", "(0,5)", "(0,6)"}, {"(1,0)", "(1,1)", "(1,2)", "(1,3)", "(1,4)", "(1,5)", "(1,6)"}, {"(2,0)", "(2,1)", "(2,2)", "(2,3)", "(2,4)", "(2,5)", "(2,6)"}, {"(3,0)", "(3,1)", "(3,2)", "(3,3)", "(3,4)", "(3,5)", "(3,6)"}, {"(4,0)", "(4,1)", "(4,2)", "(4,3)", "(4,4)", "(4,5)", "(4,6)"}, {"(5,0)", "(5,1)", "(5,2)", "(5,3)", "(5,4)", "(5,5)", "(5,6)"}, {"(6,0)", "(6,1)", "(6,2)", "(6,3)", "(6,4)", "(6,5)", "(6,6)"}};
        String[][] patch = t.patch(input, 0, 0, 3, 1);
        String[][] solution = new String[][]{{"(3,1)", "(0,1)", "(0,2)", "(0,3)", "(0,4)", "(0,5)", "(0,6)"}, {"(4,1)", "(1,1)", "(1,2)", "(1,3)", "(1,4)", "(1,5)", "(1,6)"}, {"(5,1)", "(2,1)", "(2,2)", "(2,3)", "(2,4)", "(2,5)", "(2,6)"}, {"(3,0)", "(0,0)", "(3,2)", "(3,3)", "(3,4)", "(3,5)", "(3,6)"}, {"(4,0)", "(1,0)", "(4,2)", "(4,3)", "(4,4)", "(4,5)", "(4,6)"}, {"(5,0)", "(2,0)", "(5,2)", "(5,3)", "(5,4)", "(5,5)", "(5,6)"}, {"(6,0)", "(6,1)", "(6,2)", "(6,3)", "(6,4)", "(6,5)", "(6,6)"}};
        assertEquals(Arrays.deepHashCode(solution), Arrays.deepHashCode(patch));
        isSame(solution, patch);
    }
    private boolean isSame(String[][] solution, String[][] patch) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                assertEquals(solution[i][j], patch[i][j]);
            }
        }
        return false;
    }

}