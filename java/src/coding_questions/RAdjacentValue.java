package coding_questions;

/**
 * Created by Odin on 2016-10-25.
 */
//Find the largest index distance that has adjacent values.
    //That is, find the furthest index distance of the two values where nothing in the array is between those two values.
public interface RAdjacentValue {
    //Given an array of signed 32-bit integers, find largest adjacent. Expect an array 40,000 integers long
    //Space: O(N) beyond input
    //Time: O(nlogn)
    int adjacent(int[] a);

}
