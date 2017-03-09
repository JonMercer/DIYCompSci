package coding_questions;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Odin on 2017-03-08.
 */
public class YSortMoviesTest {

    YSortMovies y;
    List<YSortMovies.YMovies> input;
    @Before
    public void setUp() throws Exception {
        y = new YSortMoviesImpl();
        input = new ArrayList<>();
    }

    @Test
    public void sortMoviesByAverageRating() throws Exception {
        YSortMovies.YMovies django = createMovie( "Django", new int[]{5, 4, 3, 3, 2, 4, 1} ); //3.1429
        YSortMovies.YMovies inception = createMovie( "Inception", new int[]{3, 4, 5, 2, 2, 5, 5} ); //3.7143
        YSortMovies.YMovies wallE = createMovie( "Wall-e", new int[]{5} );
        YSortMovies.YMovies silence = createMovie( "Silence of the Lambs", new int[]{2, 3, 3, 4, 3, 2, 1, 1, 1, 1, 1, 1} );//1.9167
        input.add( django );
        input.add( inception );
        input.add( wallE );
        input.add( silence );

        List<YSortMovies.YMovies> expected = new ArrayList<>();
        expected.add( wallE );
        expected.add( inception );
        expected.add( django );
        expected.add( silence );

        List<YSortMovies.YMovies> yMovies = y.sortMoviesByAverageRating( input );

        assertEquals( expected, yMovies );

    }

    private YSortMovies.YMovies createMovie(String name, int[] ratings) {
        YSortMovies.YMovies movie = new YSortMovies.YMovies( name );
        for (int rating : ratings) {
            movie.addRating( rating );
        }
        return movie;
    }

}