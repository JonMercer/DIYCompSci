package sorting;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Odin on 2016-10-26.
 */
public class DIYQuicksortImpl<T extends Comparable<T>> implements DIYQuicksort<T> {

    public T[] sort(T[] arr) {
        if(arr == null) return null;
        if(arr.length == 0) return arr;

        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private void sort(T[] arr, int iLeft, int iRight) {
        if (iRight <= iLeft) {
            return;
        }

        int iPivot = ThreadLocalRandom.current().nextInt(iLeft, iRight + 1);

        //move the pivot to the end
        swap(iPivot, iRight, arr);
        iPivot = iRight;

        //iterate through the array
        int pointer = iLeft;
        while (pointer < iPivot) {
            if (arr[pointer].compareTo(arr[iPivot]) > 0) { //The main difference with generic vs integer
                //swap pointer with left of pivot
                swap(pointer, iPivot - 1, arr);

                //swap left of pivot with pivot
                swap(iPivot - 1, iPivot, arr);
                continue;
            }
            pointer++;
        }

        //do two splits
        sort(arr, iLeft, iPivot - 1);
        sort(arr, iPivot + 1, iRight);
    }

    private void swap(int from, int to, T[] arr) {
        T temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }


    public int[] sort(int[] arr) {
        if (arr == null) return null;
        if (arr.length == 0) return arr;

        sort(arr, 0, arr.length-1);
        return arr;
    }

    private void sort(int[] arr, int iLeft, int iRight) {
        if (iRight <= iLeft) {
            return;
        }

        int iPivot = ThreadLocalRandom.current().nextInt(iLeft, iRight + 1);

        //move the pivot to the end
        swap(iPivot, iRight, arr);
        iPivot = iRight;

        //iterate through the array
        int pointer = iLeft;
        while (pointer < iPivot) {
            if (arr[pointer] > arr[iPivot]) {
                //swap pointer with left of pivot
                swap(pointer, iPivot - 1, arr);

                //swap left of pivot with pivot
                swap(iPivot - 1, iPivot, arr);
                continue;
            }
            pointer++;
        }

        //do two splits
        sort(arr, iLeft, iPivot - 1);
        sort(arr, iPivot + 1, iRight);
    }

    private void swap(int from, int to, int[] arr) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

}
