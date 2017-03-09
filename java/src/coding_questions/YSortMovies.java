package coding_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odin on 2017-03-08.
 */
public interface YSortMovies {

    class YMovies {
        private List<Integer> ratings = new ArrayList<>();
        String name;

        public YMovies(String name) {
            this.name = name;
        }
        public void addRating(int i) {
            ratings.add( i );
        }

        public List<Integer> getRatings() {
            return ratings;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if(!(obj instanceof YMovies)) return false;

            YMovies movie = (YMovies) obj;

            if (!movie.ratings.equals( this.ratings )) {
                return false;
            }

            return movie.name.equals( this.name );
        }

        @Override
        public int hashCode() {
            return ratings.hashCode() + name.hashCode();
        }

    }


    List<YMovies> sortMoviesByAverageRating(List<YMovies> movies);


}
