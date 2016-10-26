package data_structure;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYLinkedListNode {
    private String item = null;
    private DIYLinkedListNode next = null;
    private DIYLinkedListNode parent = null;

    public DIYLinkedListNode(String item, DIYLinkedListNode parent) {
        this.item = item;
        this.parent = parent;
    }

    public DIYLinkedListNode() {

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public DIYLinkedListNode getNext() {
        return next;
    }

    public void setNext(DIYLinkedListNode next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public DIYLinkedListNode getParent() {
        return parent;
    }

    public void setParent(DIYLinkedListNode newParent) {
        this.parent = newParent;
    }
}
