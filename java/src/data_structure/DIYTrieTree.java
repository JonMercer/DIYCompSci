package data_structure;

import java.util.List;

/**
 * Created by Odin on 2016-10-28.
 */
public interface DIYTrieTree {
    void add(String s);

    void clear();

    List<String> predict(String s);

    int size();
}
