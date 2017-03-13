package coding_questions;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Odin on 2017-03-09.
 */
public class YColorCountHarderTest {

    YColorCountHarder y;
    @Before
    public void setUp() throws Exception {
        y = new YColorCountHarderImpl();
    }

    @Test
    public void getMaxColors() throws Exception {
        List<List<String>> input = new ArrayList<>();

        //red x 2, blue x 2, green x2
        input.add( Arrays.asList( "red", "blue", "green" ) );
        input.add( Arrays.asList( "blue", "yellow", "red" ) );
        input.add( Arrays.asList( "green", "white", "black" ) );

        List<String> expected = Arrays.asList( "blue", "green", "red" );

        List<String> output = y.getMaxColors( input );

        assertEquals( expected, output );
    }

    @Test
    public void getNoColors() throws Exception {
        List<List<String>> input = new ArrayList<>();

        List<String> expected = new ArrayList<>();

        List<String> output = y.getMaxColors( input );

        assertEquals( expected, output );
    }

    @Test
    public void getOneColor() throws Exception {
        List<List<String>> input = new ArrayList<>();

        input.add( Arrays.asList( "green" ) );

        List<String> expected = Arrays.asList( "green" );

        List<String> output = y.getMaxColors( input );

        assertEquals( expected, output );
    }


}