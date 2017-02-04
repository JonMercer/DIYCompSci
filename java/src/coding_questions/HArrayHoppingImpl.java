package coding_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odin on 2017-02-01.
 */
public class HArrayHoppingImpl implements HArrayHopping {

    @Override
    public List<String> getHops(List<Integer> ints) {
        List<String> lst = new ArrayList<>();
        if(ints.size() == 0) {
            lst.add("out");
            return lst;
        } else if (ints.size() == 1 && ints.get(0) == 0) {
            lst.add("failure");
            return lst;
        }

        int i = 0;
        while (i < ints.size()) {
            lst.add(String.valueOf(i));
            i = getNextHop(ints, i);
            if (i == -1) {
                lst.add("out");
                break;
            } else if (ints.get(i) == 0) {
                lst.clear();
                lst.add("failure");
                break;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        if (lst.size() == 0) {
            System.out.println("failure");
        } else if (lst.size() == 1) {
            System.out.println(lst.get(0));
        } else {
            stringBuffer.append(lst.get(0));
            for (int j = 1; j < lst.size(); j++) {
                stringBuffer.append(", " + lst.get(j));
            }
            System.out.println(stringBuffer);
        }
        return lst;
    }

    public int getNextHop(List<Integer> ints, int currentHop) {
        if((ints.get(currentHop)+ currentHop) >= ints.size()) {
            return -1;
        }

        int maxIndex = currentHop;

        for(int i = currentHop+1; i <= (ints.get(currentHop) + currentHop); i ++) {//watch for out of bounds
            if ((ints.get(i) + i) > (ints.get(maxIndex) + maxIndex)) {
                maxIndex = i;
            }
        }
        if (currentHop == maxIndex) {
            return ++maxIndex;
        }
        return maxIndex;
    }

    /**
    @Override
    public int[] getHops(int[] arr) {
        if(arr.length == 0) {
            return new int[]{-1};
        } else if( arr.length == 1 && arr[0] == 0) {
            return new int[]{};
        }

        List<Integer> lst = new ArrayList<>();
        int currentSpot = 0;
        int tempMaxIndex = 1;


        //[4,0,4,2,0,1,4,5,3,0,0,2,4,1]
        // x\- - - -|
        //     * - -|- - <- pick this
        //       * -|-
        //[4,0,4,2,0,1,4,5,3,0,0,2,4,1]
        //     x - -\- -|
        //       * -\-  |<- can be ignored
        //           * -|
        //             *|- - - -
        //[4,0,4,2,0,1,4,5,3,0,0,2,4,1]
        //             x\- - - -|
        //              \* - - -|- -
        //                 * - -|- <- can be ignored
        //                   *  |
        //                     *|
        //[4,0,4,2,0,1,4,5,3,0,0,2,4,1]
        //               x - - -\- -|
        //                       * -|-
        //                         *|- -# <- -1
        for (int i = 1; i < arr.length; i++) {
            System.out.println("i:" + i + " currentSpot:" + currentSpot + " maxIndex:" + tempMaxIndex);
            if(currentSpot + arr[currentSpot] == i) { //BUG >=?
                lst.add(currentSpot);
                currentSpot = tempMaxIndex;
            }

            if(arr[i] + i > (arr[tempMaxIndex] + tempMaxIndex)) {
                tempMaxIndex = i;
            }
        }
        lst.add(tempMaxIndex);
        lst.add(-1);

        return toArray(lst);
    }
     **/
}
