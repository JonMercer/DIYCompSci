package data_structure;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYLinkedListImpl implements DIYLinkedList {
    DIYLinkedListNode node;

    @Override
    public void push(String item) {
        if (node == null) {
            node = new DIYLinkedListNode();
            node.setItem(item);
            return;
        }

        if (node.getItem() == null) {
            node.setItem(item);
            return;
        }

        DIYLinkedListNode tempNode = node;
        while (tempNode.hasNext()) {
            tempNode = tempNode.getNext();
        }

        DIYLinkedListNode newNode = new DIYLinkedListNode(item, tempNode);
        tempNode.setNext(newNode);
    }

    @Override
    public String pop() {
        if (node == null) {
            return null;
        }

        if (!node.hasNext()) {
            String temp = node.getItem();
            node = null;
            return temp;
        }

        DIYLinkedListNode tempNode = node;
        while (tempNode.hasNext()) {
            tempNode = tempNode.getNext();
        }
        String toReturn = tempNode.getItem();
        tempNode.getParent().setNext(null);
        return toReturn;
    }

    @Override
    public boolean remove(String item) {
        if (node == null) {
            return false;
        }

        if (node.getItem().equals(item)) {
            if (node.hasNext()) {
                node = node.getNext();
                node.setParent(null);
            } else {
                node = null;
            }
            return true;
        }

        DIYLinkedListNode tempNode = node;
        while (tempNode.hasNext()) {
            if (tempNode.getItem().equals(item)) {
                if (tempNode.hasNext()) {
                    DIYLinkedListNode nodeParent = tempNode.getParent();
                    tempNode = tempNode.getNext();
                    tempNode.setParent(nodeParent);
                }
                return true;
            }
            tempNode = tempNode.getNext();
        }


        return false;
    }

    @Override
    public String get(int i) {
        return getItem(i, node);
    }

    private String getItem(int i, DIYLinkedListNode tempNode) {
        if (tempNode == null) {
            return null;
        }

        if (i == 0) {
            if (tempNode.getItem() == null) {
                return null;
            } else {
                return tempNode.getItem();
            }
        }

        return getItem(i--, tempNode.getNext());
    }

    @Override
    public int length() {
        int len = 0;
        if (node == null) {
            return len;
        }
        len++;
        DIYLinkedListNode tempNode = node;
        while (tempNode.hasNext()) {
            len++;
            tempNode = tempNode.getNext();
        }

        return len;
    }

    @Override
    public boolean isEmpty() {
        if (node == null) {
            return true;
        }
        return false;
    }

    @Override
    public void printList() {

    }
}
