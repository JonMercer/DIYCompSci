package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Odin on 2016-10-28.
 */
public class DIYTrieTreeNode implements Comparable {
    private char item;
    private int count = 1;
    List<DIYTrieTreeNode> children = new ArrayList<>();
    private boolean endOfWord = false;

    public DIYTrieTreeNode(char item) {
        this.item = item;
    }

    public DIYTrieTreeNode(char a, int i) {
        this.item = a;
        this.count = i;
    }

    public DIYTrieTreeNode setChild(char c) {
        DIYTrieTreeNode childToReturn = null;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getItem() == c) {
                childToReturn = children.get(i);
                childToReturn.incrementCount();
                break;
            }
        }

        if (childToReturn == null) {
            childToReturn = new DIYTrieTreeNode(c);
            children.add(childToReturn);
        }
        Collections.sort(children);
        return childToReturn;
    }

    private void incrementCount() {
        count++;
    }

    public char getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DIYTrieTreeNode> getChildren() {
        return children;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() != this.getClass()) {
            return -99;
        }
        if (this.count == ((DIYTrieTreeNode) o).count) {
            return 0;
        } else if (this.count < ((DIYTrieTreeNode) o).count) {
            return -1;
        } else {
            return 1;

        }
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord() {
        endOfWord = true;
    }
}
