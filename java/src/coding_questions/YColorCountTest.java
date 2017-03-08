package coding_questions;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Odin on 2017-03-08.
 */
public class YColorCountTest {

    private YColorCount y;

    private List<String> input;
    @Before
    public void setUp() throws Exception {
        y = new YColorCountImpl();
        input = new ArrayList<>();
    }

    @Test
    public void getLargestColorCount() throws Exception {
        input.add( "Blue" );
        input.add( "Blue" );
        input.add( "White" );
        input.add( "White" );
        input.add( "Pink" );
        input.add( "Blue" );

        String output = y.getLargestColorCount( input );

        assertEquals( "Blue", output );
    }


    @Test
    public void getLargestColorCountSame() throws Exception {
        input.add( "Blue" );
        input.add( "Red" );
        input.add( "White" );
        input.add( "Black" );
        input.add( "Pink" );
        input.add( "Green" );

        String output = y.getLargestColorCount( input );

        assertEquals( "TIE", output );
    }


    @Test
    public void getLargestColorCountError() throws Exception {

        String output = y.getLargestColorCount( input );

        assertEquals( "ERROR", output );
    }

}