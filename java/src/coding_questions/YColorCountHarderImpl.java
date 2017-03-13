package coding_questions;

import java.util.*;

/**
 * Created by Odin on 2017-03-09.
 */
public class YColorCountHarderImpl implements YColorCountHarder {
    @Override
    public List<String> getMaxColors(List<List<String>> colors) {
        Map<String, Integer> map = new HashMap<>();

        int maxCount = 1;
        for (List<String> colorList : colors) {
            for (String color : colorList) {
                Integer integer = map.get( color );

                if (integer == null) {
                    map.put( color, 1 );
                    continue;
                }

                integer++;
                if (integer > maxCount) maxCount = integer;
                map.put( color, integer );
            }
        }

        Set<String> maxColors = map.keySet();

        TreeSet<String> sortedSet = new TreeSet<>();
        for (String color : maxColors) {
            if (map.get( color ) == maxCount) {
                sortedSet.add( color );
            }
        }

        return new ArrayList<>( sortedSet );


    }
}
