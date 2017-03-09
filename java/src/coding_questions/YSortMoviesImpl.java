package coding_questions;

import java.util.List;

/**
 * Created by Odin on 2017-03-08.
 */
public class YSortMoviesImpl implements YSortMovies {


    @Override
    public List<YMovies> sortMoviesByAverageRating(List<YMovies> movies) {
        if (movies.size() <= 1) {
            return movies;
        }

        //insertion sort?
        for (int i = 0; i < movies.size() - 1; i++) {
            for (int j = i + 1; j < movies.size(); j++) {
                    if (getRatingAverage( movies.get( j ) ) > getRatingAverage( movies.get( i ) )) {
                        mySwap( movies, i, j );
                    }
                }
        }
        return movies;
    }

    private void mySwap(List<YMovies> movies, int i, int j) {
        YMovies temp = movies.get( i );
        movies.set( i, movies.get( j ) );
        movies.set( j, temp );
    }

    private double getRatingAverage(YMovies movie) {
        int sum = 0;
        for (Integer integer : movie.getRatings()) {
            sum += integer;
        }

        return (double) sum / movie.getRatings().size();
    }


}
