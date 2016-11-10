package coding_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odin on 2016-11-02.
 */
//This is a better solution: http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
public class MSwirlImpl implements MSwirl {
    enum Direction{
        N,
        S,
        E,
        W
    }

    @Override
    public String swirl(char[][] arr) {
        List<Character> characters = new ArrayList<>();
        swirl(arr, Direction.E, -1, 0, 0, 0, arr.length, arr[0].length, characters,0);
        String toReturn = "";
        for (Character character : characters) {
            toReturn += character;
        }
        return toReturn;
    }

    private void swirl(
            char[][] arr,
            Direction dir,
            int x,
            int y,
            int hStep,
            int vStep,
            int hMax,
            int vMax,
            List<Character> chars,
            int step) {
//        System.out.println("d:"+dir +" x:"+x +" y:"+ y +" hS:"+ hStep +" vS:"+ vStep +" hM:"+ hMax +" vM:"+ vMax +" ## "+ chars.toString());
        ++step;

        if (step == arr.length * arr[0].length + 1) {
            return;
        }

        switch (dir) {
            case E:
                x++;
                hStep++;
                chars.add(arr[x][y]);
                if (hStep == hMax) {
                    vMax--;
                    hStep = 0;
                    swirl(arr, Direction.S, x, y, hStep, vStep, hMax, vMax, chars, step);
                } else {
                    swirl(arr, dir, x, y, hStep, vStep, hMax, vMax, chars, step);
                }
                break;
            case S:
                y++;
                vStep++;
                chars.add(arr[x][y]);
                if (vStep == vMax) {
                    hMax--;
                    vStep = 0;
                    swirl(arr, Direction.W, x, y, hStep, vStep, hMax, vMax, chars, step);
                } else {
                    swirl(arr, dir, x, y, hStep, vStep, hMax, vMax, chars, step);
                }
                break;
            case W:
                x--;
                hStep++;
                chars.add(arr[x][y]);
                if (hStep == hMax) {
                    vMax--;
                    hStep = 0;
                    swirl(arr, Direction.N, x, y, hStep, vStep, hMax, vMax, chars, step);
                } else {
                    swirl(arr, dir, x, y, hStep, vStep, hMax, vMax, chars, step);
                }
                break;
            case N:
                y--;
                vStep++;
                chars.add(arr[x][y]);
                if (vStep == vMax) {
                    hMax--;
                    vStep = 0;
                    swirl(arr, Direction.E, x, y, hStep, vStep, hMax, vMax, chars, step);
                } else {
                    swirl(arr, dir, x, y, hStep, vStep, hMax, vMax, chars, step);
                }
                break;
        }
    }
}


