package sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-11-06.
 */
public class DIYSelectionSortImplTest {
    DIYSelectionSort s;
    @Before
    public void setUp() throws Exception {
        s = new DIYSelectionSortImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sort() throws Exception {
        int[] input = new int[]{5, 4, 3, 2, 1};
        int[] output = s.sort(input);
        int[] solution = new int[]{1, 2, 3, 4, 5};
        checkSort(solution, output);

        input = new int[]{1, 2, 3, 4};
        solution = new int[]{1, 2, 3, 4};
        checkSort(solution, s.sort(input));


        checkSort(new int[]{-20, -4, 0, 4, 40}, s.sort(new int[]{4, -4, 40, 0, -20}));
    }

    private void checkSort(int[] solution, int[] output) {
        assertEquals(solution.length, output.length);
        for (int i = 0; i < solution.length; i++) {
            assertEquals(solution[i], output[i]);
        }
    }

}