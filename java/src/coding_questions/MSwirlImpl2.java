package coding_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odin on 2016-11-02.
 */
public class MSwirlImpl2 implements MSwirl {
    @Override
    public String swirl(char[][] arr) {
        List<Character> characters = new ArrayList<>();
        mySwirl(arr, characters);
        String toReturn = "";
        for (Character character : characters) {
            toReturn += character;
        }
        return toReturn;
    }

    private void mySwirl(char[][] arr, List<Character> characters) {
        if (arr.length == 1) {
            characters.add(arr[0][0]);
            return;
        }
        //add top
        for (int i = 0; i < arr.length; i++) {
            characters.add(arr[i][0]);
        }

        //add right
        for(int i = 1; i < arr.length; i++) {
            characters.add(arr[arr.length - 1][i]);
        }
        char[][] charMini = stripTopAndRight(arr);


        mySwirl(rotate180(charMini), characters);
    }

    char[][] rotate180(char[][] arr) {
        //reverse row
        for (int i = 0; i < (int) Math.floor((double) arr.length / 2); i++) {
            char[] temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        //reverse colum
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (int) Math.floor((double) arr[0].length / 2); j++) {
                char temp = arr[i][j];
                arr[i][j] = arr[i][arr[0].length - 1 - j];
                arr[i][arr[0].length - 1 - j] = temp;
            }
        }
        return arr;
    }

    char[][] stripTopAndRight(char[][] arr) {
        char[][] arrMini = new char[arr.length - 1][arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                arrMini[i][j-1] = arr[i][j];
            }
        }
        return arrMini;
    }
}

