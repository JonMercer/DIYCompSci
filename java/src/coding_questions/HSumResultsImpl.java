package coding_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Odin on 2017-03-07.
 */
public class HSumResultsImpl implements HSumResults {
    @Override
    public boolean targetInArray(int[] numbers, int target) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException();
        }

        //sort
        List<Integer> list = arrayToList( numbers );
        Collections.sort( list );

        int secondNumber;
        for (int i = 0; i < list.size()-1; i++) {
            secondNumber = target - list.get( i );

            if (binary( secondNumber, list, i + 1, list.size() - 1 )) {
                return true;
            }
        }
        return false;
    }

    private boolean binary(int targetNumber, List<Integer> list, int left, int right) {
        int median = Math.floorDiv( right + left, 2 );
        if ((right - left) <= 1) {
            return list.get( median ) == targetNumber || list.get( right ) == targetNumber;
        }

        if (targetNumber > list.get( median )) { // right
            return binary( targetNumber, list, median, right );
        } else { //left
            return binary( targetNumber, list, left, median );
        }
    }

    private List<Integer> arrayToList(int[] numbers) {
        List<Integer> toReturn = new ArrayList<>();
        for (int number : numbers) {
            toReturn.add( number );
        }
        return toReturn;
    }
}
