package data_structure;

/**
 * Created by Odin on 2016-10-24.
 */
public interface DIYHashMap<K, V> {
    void clear();

    boolean containsKey(K k);

    boolean containsValue(V v);

    V get(K k);

    boolean isEmpty();

    void put(K k, V v);

    void remove(K k);

    int size();
}
