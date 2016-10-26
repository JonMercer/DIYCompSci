package coding_questions;

/**
 * Created by Odin on 2016-10-25.
 */
public class RAdjacentValueImpl implements RAdjacentValue {
    int[] sorted;
    @Override
    public int adjacent(int[] arr) {
        sorted = sort(arr);

        //bounce between large numbers
        for(int len = arr.length-1; len > 0; len--) {
            for (int i = 0; i < (arr.length - len); i++) {
                if (!contained(arr[i], arr[i + len])) {
                    return len;
                }
            }
        }
        return -1;

        //check if it's inside
        //-sort first though
        //-binary through the sort
    }

    private int[] sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        return quicksort(start, end, arr);
    }

    public int[] quicksort(int start, int end, int[] arr) {
        if(end < start) {
            return arr;
        }
        if ((end - start) < 1) {
            return arr;
        }
        int pivot = end;
        int i = start;
        while (i < pivot) {
            if (arr[i] > arr[pivot]) {
                //swap i with left of pivot then swap pivot with left of pivot
                int temp = arr[pivot];
                arr[pivot] = arr[i];
                arr[i] = arr[pivot - 1];
                arr[pivot - 1] = temp;
                pivot--;
                continue;
            }
            i++;
        }
        arr = quicksort(pivot+1, end, arr);
        return quicksort(start, pivot-1, arr);
    }

    private boolean contained(int a, int b) {

        return false;
    }
}
