package data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odin on 2016-10-28.
 */
public class DIYTrieTreeImpl implements DIYTrieTree {
    DIYTrieTreeNode root = new DIYTrieTreeNode();

    @Override
    public void add(String s) {
        if (s == null || s.equals("")) {
            return;
        }

        addToTree(root, s, 0);
    }

    private void addToTree(DIYTrieTreeNode node, String s, int i) {
        if (i == s.length()) {
            return;
        }

        DIYTrieTreeNode child = node.findChild(s.charAt(i));

        if (child == null) {
            child = new DIYTrieTreeNode(s.charAt(i), s.length() == i + 1);
            node.addChild(child);
            node.customSort();
        } else {
            child.increment();
            node.customSort();
        }
        addToTree(child, s, ++i);
    }


    @Override
    public void clear() {
        root = new DIYTrieTreeNode();
    }

    @Override
    public List<String> predict(String s) {
        DIYTrieTreeNode lastNode = getLastLetterNodeFromString(root, s, 0);
        List<String> strings = new ArrayList<>();
        getPredictions(lastNode, strings, s.substring(0, s.length() - 1));
        return strings;
    }

    private void getPredictions(DIYTrieTreeNode node, List<String> strings, String preString) {
        if (node == null) {
            return;
        }

        if (node.isEndOfWord()) {
            strings.add(preString + node.getItem());
        }

        preString += node.getItem();

        for (DIYTrieTreeNode child : node.getChildren()) {
            getPredictions(child, strings, preString);
        }
    }

    private DIYTrieTreeNode getLastLetterNodeFromString(DIYTrieTreeNode node, String s, int i) {
        if (i == s.length()) {
            return node;
        }

        DIYTrieTreeNode child = node.findChild(s.charAt(i));

        return getLastLetterNodeFromString(child, s, ++i);
    }

    @Override
    public int size() {
        return treeSize(root, 0) - 1;
    }

    private int treeSize(DIYTrieTreeNode node, int i) {
        if (node == null) {
            return i;
        }
        for (DIYTrieTreeNode child : node.getChildren()) {
            i = treeSize(child, i);
        }
        return i + 1;
    }

    @Override
    public int wordCount() {
        return wordCount(root, 0);
    }

    private int wordCount(DIYTrieTreeNode node, int i) {
        if (node.isEndOfWord()) {
            i++;
        }
        for (DIYTrieTreeNode child : node.getChildren()) {
            i = wordCount(child, i);
        }
        return i;
    }

    public void debug() {
        printAllChars(root, "");
    }

    private void printAllChars(DIYTrieTreeNode node, String s) {
        s += "\t";
        char item = node.getItem();
        if (node.isEndOfWord()) {
            item = Character.toUpperCase(item);
        }
        System.out.println(s + item);

        for (DIYTrieTreeNode child : node.getChildren()) {
            printAllChars(child, s);
        }
    }


}
