package data_structure;

import java.util.Iterator;

/**
 * Created by Odin on 2016-10-24.
 */
public class DIYHashMapImpl<K, V> implements DIYHashMap<K, V> {
    private static final int INITIAL_SIZE = 16;
    private static final int PERCENT_FULL = 80;
    private DIYHashMapNode<K,V>[] arr = new DIYHashMapNode[INITIAL_SIZE];

    public DIYHashMapImpl(int size) {
        arr = new DIYHashMapNode[size];
    }

    public DIYHashMapImpl() {

    }

    @Override
    public void clear() {
        arr = new DIYHashMapNode[INITIAL_SIZE];
    }

    @Override
    public boolean containsKey(K k) {
        Iterator<DIYHashMapNode<K, V>> iter = iterator();
        while (iter.hasNext()) {
            DIYHashMapNode next = iter.next();
            if (next.getK().equals(k)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        Iterator<DIYHashMapNode<K, V>> iter = iterator();
        while (iter.hasNext()) {
            DIYHashMapNode next = iter.next();
            if (next.getV().equals(v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K k) {
        Iterator<DIYHashMapNode<K, V>> iterator = iterator();
        while (iterator.hasNext()) {
            DIYHashMapNode<K, V> next = iterator.next();
            if (next.getK().equals(k)) {
                return next.getV();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        Iterator<DIYHashMapNode<K, V>> iterator = iterator();
        if (iterator.hasNext()) {
            return false;
        }
        return true;
    }

    @Override
    public void put(K k, V v) {
        if (size() * 100 / arr.length >= PERCENT_FULL) {
            resize();
        }

        int hash = k.hashCode() % arr.length;
        if (arr[hash] == null) {
            arr[hash] = new DIYHashMapNode<>(k, v);
        } else {
            DIYHashMapNode<K, V> temp = arr[hash];
            while (temp.getChild() != null){
                temp = temp.getChild();
            }
            DIYHashMapNode<K, V> newNode = new DIYHashMapNode<>(k, v);
            temp.setChild(newNode);
            newNode.setParent(temp);
        }
    }

    private void resize() {
        DIYHashMap<K, V> newMap = new DIYHashMapImpl<>(arr.length * 2);
        Iterator<DIYHashMapNode<K, V>> iterator = iterator();
        while (iterator.hasNext()) {
            DIYHashMapNode<K, V> next = iterator.next();
            newMap.put(next.getK(), next.getV());
        }
        this.arr = ((DIYHashMapImpl<K, V>) newMap).arr;
    }

    @Override
    public void remove(K k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            DIYHashMapNode<K, V> temp = arr[i];
            do {
                if (temp.getK().equals(k)) {
                    if(temp.getParent() != null) {
                        temp.getParent().setChild(temp.getChild());
                    }
                    if(temp.getChild() != null) {
                        temp.getChild().setParent(temp.getParent());
                    }
                    if (temp.getChild() == null && temp.getParent() == null) {
                        arr[i] = null;
                        return;
                    }
                    temp.setParent(null);
                    temp.setChild(null);
                    return;
                }
                temp = temp.getChild();
            } while (temp != null);
        }
    }

    @Override
    public int size() {
        int size = 0;
        Iterator<DIYHashMapNode<K, V>> iter = iterator();
        while (iter.hasNext()) {
            iter.next();
            size++;
        }
        return size;
    }

    private Iterator<DIYHashMapNode<K,V>> iterator() {

        return new Iterator<DIYHashMapNode<K,V>>() {
            int i = 0;
            DIYHashMapNode<K,V> current;
            DIYHashMapNode<K,V> next;

            @Override
            public boolean hasNext() {
                return getNext() != null;
            }

            @Override
            public DIYHashMapNode<K, V> next() {
                current = getNext();
                return current;
            }

            private DIYHashMapNode<K, V> getNext() {
                if (next == null) {
                    for (; i < arr.length; i++) {
                        if (arr[i] == null) {
                            continue;
                        }
                        next = arr[i];
                        return next;
                    }
                }

                if (next == null && current == null) {
                    return null;
                }

                if (current == next) {
                    if (next.getChild() != null) {
                        next = next.getChild();
                        return next;
                    } else {
                        i++;
                        for (; i < arr.length; i++) {
                            if (arr[i] == null) {
                                continue;
                            }
                            next = arr[i];
                            return next;
                        }
                    }
                } else {
                    return next;
                }
                return null;
            }
        };
    }
}
