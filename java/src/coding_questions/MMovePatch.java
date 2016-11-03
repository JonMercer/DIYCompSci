package coding_questions;

/**
 * Created by Odin on 2016-10-26.
 */
//given a 2D array initial coords, len, and width, swap all items to bottom right of box
public interface MMovePatch {
    String[][] patch(String[][] arr, int x1, int y1, int len, int width);
}
