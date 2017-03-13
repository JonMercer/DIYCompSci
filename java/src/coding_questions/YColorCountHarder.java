package coding_questions;

import java.util.List;

/**
 * Created by Odin on 2017-03-09.
 */
public interface YColorCountHarder {

    //given a 2-D array of color strings, find the color that appears the most.
    //If there's a tie for largest number then return a sorted list
    List<String> getMaxColors(List<List<String>> colors);
}
