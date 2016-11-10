package sorting;

/**
 * Created by Odin on 2016-11-06.
 */
public class DIYSelectionSortImpl implements DIYSelectionSort {
    @Override
    public int[] sort(int[] a) {

        int smallest = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int smallestIndex = i;
            for (int j = i; j<a.length; j++) {
                if (a[j] < a[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[smallestIndex];
            a[smallestIndex] = temp;
        }
        return a;
    }
}
