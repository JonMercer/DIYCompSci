package sorting;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Odin on 2016-10-26.
 */
public class DIYQuicksortImpl<E> implements DIYQuicksort<E> {

    public E[] sort(E[] arr) {
        return (E[]) new Object[20];
    }

    public int[] sort(int[] arr) {
        if (arr == null) return null;
        if (arr.length == 0) return arr;

        return sort(arr, 0, arr.length-1);
    }

    private int[] sort(int[] arr, int iLeft, int iRight) {
        if (iRight <= iLeft) {
            return arr;
        }

        int iPivot = ThreadLocalRandom.current().nextInt(iLeft, iRight + 1);

        //move the pivot to the end
        arr = swap(iPivot, iRight, arr);
        iPivot = iRight;

        //iterate through the array
        int pointer = iLeft;
        while (pointer < iPivot) {
            if (arr[pointer] > arr[iPivot]) {
                //swap pointer with left of pivot
                arr = swap(pointer, iPivot - 1, arr);

                //swap left of pivot with pivot
                arr = swap(iPivot - 1, iPivot, arr);
                continue;
            }
            pointer++;
        }

        //do two splits
        arr = sort(arr, iLeft, iPivot - 1);
        arr = sort(arr, iPivot + 1, iRight);
        return arr;
    }

    private int[] swap(int from, int to, int[] arr) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
        //TODO: do I even have to return or will the object change for me?
        return arr;
    }

}
