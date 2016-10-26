import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by Odin on 2016-10-25.
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        for (int i = 0; i < A.length; i++) {
            for(int j = A.length-1; j > i; j--) {
                if (A[i] == A[j]) {
                    continue;
                }
                int diff = A[i] - A[j];
                int top = 0;
                int bottom = 0;
                if (A[i] > A[j]) {
                    top = A[i];
                    bottom = A[j];
                } else {
                    top = A[j];
                    bottom = A[i];
                }

                if (!contains(top, bottom, A)) {
                    return j - i;
                }
            }
        }
        return -1;
    }

    private boolean contains(int top, int bottom, int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > bottom && A[i] < top) {
                return true;
            }
        }
        return false;
    }
}
