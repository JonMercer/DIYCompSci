package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Odin on 2016-10-28.
 */
public class DIYTrieTreeNode {
    private boolean isEndOfWord = false;
    private char item;
    private int count = 1;
    private List<DIYTrieTreeNode> children = new ArrayList<>();

    public DIYTrieTreeNode() {
        item = ' ';
    }


    public DIYTrieTreeNode(char c, boolean b) {
        isEndOfWord = b;
        this.item = c;
    }

    public DIYTrieTreeNode findChild(char c) {
        for (DIYTrieTreeNode child : children) {
            if (child.getItem() == c) {
                return child;
            }
        }
        return null;
    }

    public char getItem() {
        return item;
    }

    public void addChild(DIYTrieTreeNode child) {
        children.add(child);
    }

    public void customSort() {
        Collections.sort(children, new Comparator<DIYTrieTreeNode>() {
            @Override
            public int compare(DIYTrieTreeNode n1, DIYTrieTreeNode n2)
            {
                if (n1.count < n2.count) {
                    //return -1;
                    return 1; //reverse sort
                } else if (n1.count == n2.count) {
                    return 0;
                } else {
                    //return 1;
                    return -1; //reverse sort
                }
            }
        });
    }

    public List<DIYTrieTreeNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void increment() {
        count++;
    }
}
