package coding_questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-25.
 */
public class RAdjacentValueImplTest {
    RAdjacentValue adj;
    @Before
    public void setUp() throws Exception {
        adj = new RAdjacentValueImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void adj() throws Exception {
        assertEquals(1, adj.adjacent(new int[]{1, 2, 3, 4, 5}));
        assertEquals(4, adj.adjacent(new int[]{1, 3, 4, 5, 2}));
        assertEquals(4, adj.adjacent(new int[]{3, 5, 5, 5, 4}));
        assertEquals(-1, adj.adjacent(new int[]{5, 5, 5, 5, 5}));

    }

    @Test
    public void quicksort() throws Exception {
        int[] a = new int[]{3, 2, 1};
        assertTrue(testQuicksort(a));

        a = new int[]{1, 2, 3, 4};
        assertTrue(testQuicksort(a));

        a = new int[]{-1,-2,-3,-4,0,1,2};
        assertTrue(testQuicksort(a));

        a = new int[]{1};
        assertTrue(testQuicksort(a));

        a = new int[]{-1, 1};
        assertTrue(testQuicksort(a));

        a = new int[]{5,5,5,5};
        assertTrue(testQuicksort(a));
    }

    private boolean testQuicksort(int[] a) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        int[] quicksorted = ((RAdjacentValueImpl) adj).quicksort(0, a.length - 1, a);
        List<Integer> quickSortedList = Arrays.stream(quicksorted).boxed().collect(Collectors.toList());
        Collections.sort(list);
        return list.equals(quickSortedList);
    }

    @Test
    public void contained() throws Exception {
        int[] a = new int[]{2,4,8,16,32};
        assertFalse(((RAdjacentValueImpl) adj).contained(2, 4, a));
        assertFalse(((RAdjacentValueImpl) adj).contained(16, 32, a));
        assertTrue(((RAdjacentValueImpl) adj).contained(2, 8, a));
        assertTrue(((RAdjacentValueImpl) adj).contained(2, 32, a));

        int[] b = new int[]{11, 15, 15, 15, 16, 17, 18};
        assertFalse(((RAdjacentValueImpl) adj).contained(11, 15, b));
        assertFalse(((RAdjacentValueImpl) adj).contained(15, 16, b));
        assertTrue(((RAdjacentValueImpl) adj).contained(11, 18, b));
    }
}