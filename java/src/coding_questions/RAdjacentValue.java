package coding_questions;

/**
 * Created by Odin on 2016-10-25.
 */
//Find the largest index distance that has adjacent values
public interface RAdjacentValue {
    //Given an array of signed 32-bit integers, find largest adjacent
    //Space: O(N) beyond input
    //Time: O(nlogn)
    int adjacent(int[] a);

}
