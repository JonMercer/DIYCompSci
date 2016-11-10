package coding_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-11-06.
 */
public class GSumIntsImplTest {

    GSumInts ints;
    @Before
    public void setUp() throws Exception {
        ints = new GSumIntsImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sumNoCarry() throws Exception {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5};
        int[] solution = new int[]{1, 6, 8};
        int[] myAnswer = ints.sum(a, b);
        isSame(solution, myAnswer);

    }

    private void isSame(int[] solution, int[] myAnswer) {
        assertEquals(solution.length, myAnswer.length);
        for (int i = 0; i < solution.length; i++) {
            assertEquals(solution[i], myAnswer[i]);
        }
    }

    @Test
    public void sumCarry() throws Exception {
        int[] a = new int[]{8, 9};
        int[] b = new int[]{5, 6, 7};
        int[] solution = new int[]{6, 5, 6};
        int[] myAnswer = ints.sum(a, b);
        isSame(solution, myAnswer);
    }

    @Test
    public void sumOverflow() throws Exception {
        int[] a = new int[]{7, 8, 9};
        int[] b = new int[]{4, 5, 6};
        int[] solution = new int[]{1, 2, 4, 5};
        int[] myAnswer = ints.sum(a, b);
        isSame(solution, myAnswer);
    }



}