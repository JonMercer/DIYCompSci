package coding_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Odin on 2016-11-02.
 */
public class JAnagramImpl implements JAnagram {
    @Override
    public boolean anagram(String a, String b) {
        if (a.length() != b.length()) return false;
        if (a == "" && b != "") return false;

        String a1 = a.replaceAll("\\s", "").toLowerCase();
        String b1 = b.replaceAll("\\s", "").toLowerCase();

        return sortString(a1).equals(sortString(b1));
    }

    private List<Character> sortString(String s) {
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            charList.add(c);
        }
        Collections.sort(charList);
        return charList;
    }
}
