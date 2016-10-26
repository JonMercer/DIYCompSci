package data_structure;

import java.util.Iterator;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYHashSetImpl implements DIYHashSet {
    private static final int PERCENT_FULL = 80;
    private int maxSetSize;
    private DIYHashSetNode[] arr;

    public DIYHashSetImpl(int maxSetSize) {
        this.maxSetSize = maxSetSize;
        arr = new DIYHashSetNode[maxSetSize];
    }

    @Override
    public void add(String s) {
        if (contains(s)) {
            return;
        }

        if (size() * 100 / arr.length >= PERCENT_FULL) {
            resize();
        }

        int hash = s.hashCode() % arr.length;
        if (arr[hash] == null) {
            arr[hash] = new DIYHashSetNode(s);
            return;
        }

        DIYHashSetNode tempNode = arr[hash];
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }

        DIYHashSetNode newNode = new DIYHashSetNode(s, tempNode);
        tempNode.setNext(newNode);
    }

    private void resize() {
        Iterator<String> iterator = iterator();
        DIYHashSet newSet = new DIYHashSetImpl(arr.length * 2);
        while (iterator.hasNext()) {
            newSet.add(iterator.next());
        }
        this.arr = ((DIYHashSetImpl) newSet).arr;
    }

    @Override
    public void clear() {
        arr = new DIYHashSetNode[maxSetSize];
    }

    @Override
    public boolean contains(String s) {
        Iterator<String> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        Iterator<String> iterator = iterator();
        if (iterator.hasNext()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(String s) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }

            DIYHashSetNode node = arr[i];
            do {
                if (node.getItem().equals(s)) {
                    removeNode(node, i);
                    return true;
                }
                node = node.getNext();
            } while (node != null);
        }
        return false;
    }

    private void removeNode(DIYHashSetNode node, int arrayIndex) {
        DIYHashSetNode parent = node.getParent();
        DIYHashSetNode next = node.getNext();

        if (parent == null && next != null) {
            arr[arrayIndex] = next;
            next.setParent(null);
        } else if (parent == null && next == null) {
            arr[arrayIndex] = null;
            return;
        }

        parent.setNext(next);
        node.setParent(null);
        next.setParent(parent);
        node.setNext(null);
    }

    @Override
    public int size() {
        int size = 0;

        Iterator<String> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            size++;
        }
        return size;
    }

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {
            int i = 0;
            DIYHashSetNode current;
            DIYHashSetNode next;
            @Override
            public boolean hasNext() {
                return getNext() != null;

            }

            @Override
            public String next() {
                DIYHashSetNode next = getNext();
                current = next;
                return next.getItem();
            }

            private DIYHashSetNode getNext() {
                if (next == null) {
                    for (; i < arr.length; i++) {
                        if (arr[i] == null) {
                            continue;
                        }
                        next = arr[i];
                        return next;
                    }
                    return null;
                }

                if (next == current) {
                    if (current.getNext() != null) {
                        next = current.getNext();
                        return next;
                    }
                    i++;
                    for (; i < arr.length; i++) {
                        if (arr[i] == null) {
                            continue;
                        }
                        next = arr[i];
                        return next;
                    }
                    return null;
                } else {
                    return next;
                }
            }
        };
    }
}
