package coding_questions;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Odin on 2017-03-07.
 */
public class HSumResultsTest {

    HSumResults s;

    @Before
    public void setUp() throws Exception {
        s = new HSumResultsImpl();
    }

    @Test
    public void targetIsInArray() throws Exception {
        int[] arr = new int[]{1,2,3,4,5};
        int target = 5;

        assertTrue( s.targetInArray( arr, target ) );
    }

    @Test
    public void targetIsNotInArray() throws Exception {
        int[] arr = new int[]{1,2,3,4,5};
        int target = 99;

        assertFalse( s.targetInArray( arr, target ) );
    }



    @Test
    public void targetInArrayOfWithNegativeNumber() throws Exception {
        int[] arr = new int[]{-10,-5,2,3,4,5,14};
        int target = 4;

        assertTrue( s.targetInArray( arr, target ) );
    }


    @Test
    public void targetInArrayOfNegativeNumber() throws Exception {
        int[] arr = new int[]{-50,-40,-30,-20,1,2,3,4};
        int target = -80;
        assertTrue( s.targetInArray( arr, target ) );
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalArgument() throws Exception {
        int[] arr = new int[]{1};
        int target = 50;
        assertTrue( s.targetInArray( arr, target ) );
    }



}