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
        assertEquals(4, adj.adjacent(new int[]{3, 5, 5, 5, 4}));
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
}