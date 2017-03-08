package coding_questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Odin on 2017-03-08.
 */
public class YColorCountImpl implements YColorCount {


    private static final String ERROR = "ERROR";
    private static final String TIE = "TIE";

    @Override
    public String getLargestColorCount(List<String> list) {
        Map<String, Integer> m = new HashMap<>();

        for (String s : list) {
            if (m.containsKey( s )) {
                m.put( s, m.get( s ) + 1 );
            } else {
                m.put( s, 1 );
            }
        }

        String maxKey = null;
        int maxNum = -1;
        for (String s : m.keySet()) {
            if (m.get( s ) > maxNum) {
                maxKey = s;
                maxNum = m.get( s );
            } else if (m.get( s ) == maxNum) {
                return TIE;
            }
        }

        if (maxKey == null) {
            return ERROR;
        } else {
            return maxKey;
        }
    }
}
