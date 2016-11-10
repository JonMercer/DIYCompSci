package sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-26.
 */
public class DIYQuicksortImplTest {
    DIYQuicksort<Integer> q;
    @Before
    public void setUp() throws Exception {
        q = new DIYQuicksortImpl<>();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sort() throws Exception {

    }

    @Test
    public void sortIntAscending() throws Exception {
        int[] arr = {11, 12, 13, 14, 15};
        int[] sorted = q.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sorted[i]);
        }

        arr = new int[]{11, 12, 13, 14};
        sorted = q.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sorted[i]);
        }

        arr = new int[]{11, 12, 13};
        sorted = q.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sorted[i]);
        }

        arr = new int[]{11, 12};
        sorted = q.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sorted[i]);
        }

        arr = new int[]{11};
        sorted = q.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sorted[i]);
        }

        arr = new int[]{};
        sorted = q.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sorted[i]);
        }

    }

    @Test
    public void sortIntDecending() throws Exception {
        int[] arr = {15, 14, 13, 12, 11};
        int[] answer = {11, 12, 13, 14, 15};
        int[] sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }

        arr = new int[]{15, 14, 13, 12};
        answer = new int[]{12, 13, 14, 15};
        sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }

        arr = new int[]{15, 14, 13};
        answer = new int[]{13, 14, 15};
        sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }

        arr = new int[]{15, 14};
        answer = new int[]{14, 15};
        sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }

        arr = new int[]{15};
        answer = new int[]{15};
        sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }
    }

    @Test
    public void sortIntSame() throws Exception {
        int[] arr = {11, 12, 12, 12, 13};
        int[] answer = {11, 12, 12, 12, 13};
        int[] sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }

        arr = new int[]{13, 12, 12, 11};
        answer = new int[]{11, 12, 12, 13};
        sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }

        arr = new int[]{12, 12};
        answer = new int[]{12, 12};
        sorted = q.sort(arr);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], sorted[i]);
        }
    }

    @Test
    public void sortBig() throws Exception {
        Random rand = new Random();
        for (int j = 0; j < 333; j++) {
            //populate an array with random numbers
            int size = 4444;
            int[] big = new int[size];
            for (int i = 0; i < size; i++) {
                big[i] = rand.nextInt(size);
            }

            int[] mySort = q.sort(big);

            List<Integer> mySortList = Arrays.stream(mySort).boxed().collect(Collectors.toList());
            List<Integer> bigList = Arrays.stream(big).boxed().collect(Collectors.toList());

            Collections.sort(bigList);

            assertEquals(bigList, mySortList);
        }
    }

    @Test
    public void sortCustomItem() throws Exception {
        DIYQuicksort<DIYQuicksortCustomItem> customQuicksort = new DIYQuicksortImpl<>();
        DIYQuicksortCustomItem item1 = new DIYQuicksortCustomItem(11);
        DIYQuicksortCustomItem item2 = new DIYQuicksortCustomItem(14);
        DIYQuicksortCustomItem item3 = new DIYQuicksortCustomItem(12);
        DIYQuicksortCustomItem item4 = new DIYQuicksortCustomItem(13);

        DIYQuicksortCustomItem[] items = new DIYQuicksortCustomItem[]{
                item1, item2, item3, item4
        };

        DIYQuicksortCustomItem[] correctAnswer = new DIYQuicksortCustomItem[]{
                item1, item3, item4, item2
        };

        DIYQuicksortCustomItem[] myQuicksorted = customQuicksort.sort(items);

        for (int i = 0; i < correctAnswer.length; i++) {
            assertTrue(correctAnswer[i].equals(myQuicksorted[i]));
        }
    }

}