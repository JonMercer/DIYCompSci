package data_structure;

import java.util.Iterator;

/**
 * Created by Odin on 2016-10-23.
 */
public interface DIYHashSet {
    void add(String s);

    void clear();

    boolean contains(String s);

    boolean isEmpty();

    boolean remove(String s);

    int size();

    Iterator<String> iterator();
}
