package coding_questions;

import java.util.Random;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.floorDiv;

/**
 * Created by Odin on 2016-10-25.
 */
public class RAdjacentValueImpl implements RAdjacentValue {
    private Random r = new Random();
    @Override
    public int adjacent(int[] arr) {
        int[] sorted = sort(arr.clone());

        //bounce between large numbers
        for(int len = arr.length-1; len > 0; len--) {
            for (int i = 0; i < (arr.length - len); i++) {
                if (!contained(arr[i], arr[i + len], sorted)) {
                    return len;
                }
            }
        }
        return -1;
    }

    private int[] sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        return quicksort(start, end, arr);
    }

    int[] quicksort(int start, int end, int[] arr) {
        if(end < start) {
            return arr;
        }
        if ((end - start) < 1) {
            return arr;
        }
        int indexToSwap = r.nextInt(end-start) + start;
        arr = swap(indexToSwap, end, arr);
        int pivot = end;
        int i = start;
        while (i < pivot) {
            if (arr[i] > arr[pivot]) {
                arr = swap(i, pivot - 1, arr);
                arr = swap(pivot - 1, pivot, arr);
                pivot--;
                continue;
            }
            i++;
        }
        arr = quicksort(pivot+1, end, arr);
        return quicksort(start, pivot-1, arr);
    }

    private int[] swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    //check if sorted has numbers between a or b
    boolean contained(int a, int b, int[] sorted) {
        return contained(a, b, sorted.length / 2, sorted);
    }

    //max of 40,000 integers. Make sure I don't stackoverflow
    private boolean contained(int a, int b, int i, int[] sorted) {
        if (a == sorted[i]) {
            if (sorted[i + 1] == b) return false;
            return true;
        }

        if (sorted[i] > a) {
            //middle of left
            int nextI = floorDiv(i, 2);
            return contained(a, b, nextI, sorted);
        } else if (sorted[i] < a) {
            //middle of right
            int nextI = i + floorDiv(i, 2);
            return contained(a, b, nextI, sorted);
        }
        return false;
    }

}
