package coding_questions;

/**
 * Created by Odin on 2016-11-02.
 */
public class MMovePatchImpl implements MMovePatch {
    @Override
    public String[][] patch(String[][] arr, int x1, int y1, int len, int width) {

        String temp;

        for (int i = x1; i < x1+len; i++) {
            for(int j = y1; j < y1+width; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i + len][j + width];
                arr[i + len][j + width] = temp;
            }
        }

        return arr;
    }
}
