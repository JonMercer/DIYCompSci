import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-25.
 */
public class SolutionTest {
    Solution sol;
    @Before
    public void setUp() throws Exception {
        sol = new Solution();
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void solution() throws Exception {
        int[] ia = new int[]{-1, 3, -4, 5, 1, -6, 2, 1};
        assertEquals(1, sol.solution(ia));
    }

}