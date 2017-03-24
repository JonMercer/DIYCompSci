package coding_questions;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Odin on 2017-03-24.
 */
public class YLongestPalindromeTest {

    YLongestPalindrome y;

    @Before
    public void setUp() throws Exception {
        y = new YLongestPalindromeImpl();
    }

    @Test
    public void findLongestPalindrome() throws Exception {
        String actual = y.findLongestPalindrome( "Ana is a bonobo" );
        assertEquals( "bonob", actual );
    }

    @Test
    public void longEvenPalindrome() throws Exception {
        String actual = y.findLongestPalindrome( "What is google?" );
        assertEquals( "goog", actual );
    }

    @Test
    public void findNoPalindrome() throws Exception {
        String actual = y.findLongestPalindrome( "This is a test" );
        assertEquals( "", actual );
    }

    @Test
    public void findPalindromeEmptyString() throws Exception {
        String actual = y.findLongestPalindrome( "" );
        assertEquals( "", actual );
    }


}