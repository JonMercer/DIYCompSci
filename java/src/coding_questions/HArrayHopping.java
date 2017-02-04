package coding_questions;

import java.util.List;

/**
 * Created by Odin on 2017-02-01.
 */
public interface HArrayHopping {
    //Given an array starting at arr[0] hop from one index to the other to reach the end. Save an array of your hops. End array returns -1
    //[3,1,1,2,0] arr[0] can go to indexes 1,2,3. Let's go to index 1. From index 1 we can jump once and so on.
    //optimal solution index is [0,3,-1]
    List<String> getHops(List<Integer> arr);
}
