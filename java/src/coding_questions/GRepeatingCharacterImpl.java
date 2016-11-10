package coding_questions;

import java.util.HashSet;

/**
 * Created by Odin on 2016-11-02.
 */
public class GRepeatingCharacterImpl implements GRepeatingCharacter {
    @Override
    public char firstRepeatingCharacter(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        for (char aChar : chars) {
            if (!set.add(aChar)) {
                return aChar;
            }
        }
        return ' ';
    }
}
