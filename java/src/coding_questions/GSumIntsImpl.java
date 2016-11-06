package coding_questions;

/**
 * Created by Odin on 2016-11-06.
 */
public class GSumIntsImpl implements GSumInts {
    @Override
    public int[] sum(int[] a, int[] b) {
        if (a.length < b.length) {
            return sum(b, a);
        }
        reverse(a);
        reverse(b);
        int carry = 0;

        for (int i = 0; i < a.length; i++) {
            int sum = a[i] + carry;
            if (i < b.length) {
                sum = sum + b[i];
            }
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            a[i] = sum;

            if (i == a.length - 1 && carry > 0) {
                a = appendOneToArray(a);
                break;
            }
        }

        reverse(a);
        return a;
    }

    private void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    private int[] appendOneToArray(int[] a) {
        int[] b = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        b[a.length] = 1;
        return b;
    }
}
