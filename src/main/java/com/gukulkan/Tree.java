package com.gukulkan;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private TreeNode root;

    public boolean insert(T name, String left, String right) {
        return insert(new TreeNode<>(
                name,
                TreeNode.createNode(left),
                TreeNode.createNode(right)));
    }

    public boolean insert(TreeNode node) {
        TreeNode toInsert = insertTreeNode(root, node);

        if (toInsert == null)
            return false;

        root = toInsert;

        return true;
    }

    private TreeNode insertTreeNode(TreeNode r, TreeNode toInsert) {
        if (r == null)
            return toInsert;

        if (toInsert.right != null && toInsert.right.value.equals(r.value)) {
            toInsert.right = r;
            return toInsert;
        }

        if (toInsert.left != null && toInsert.left.value.equals(r.value)) {
            toInsert.left = r;
            return toInsert;
        }

        if (r.right != null && r.right.value.equals(toInsert.value)) {
            r.right = toInsert;
            return r;
        }

        if (r.left != null && r.left.value.equals(toInsert.value)) {
            r.left = toInsert;
            return r;
        }

        if (r.left != null && insertTreeNode(r.left, toInsert) != null) {
            return r;
        }

        if (r.right != null && insertTreeNode(r.right, toInsert) != null) {
            return r;
        }

        return null;
    }

    //Better here tu use some cache, maybe HasMap, for example. But this one implemented faster...
    public void insertAll(List<TreeNode> in) {
        int inSize = in.size();
        List<TreeNode> out = new ArrayList<>();

        for (TreeNode treeNode : in) {
            if (!this.insert(treeNode)) {
                out.add(treeNode);
            }
        }

        if (out.size() > 0 && inSize != out.size())
            insertAll(out);
        else if (inSize == out.size())
            throw new RuntimeException("There incorrect nodes");
        in.clear();
    }

    public T get(T value) {
        if (value == null)
            return null;

        TreeNode found = findNode(root, value);

        return (found == null ? null : (T) found.value);
    }

    private TreeNode findNode(TreeNode node, T value) {
        if (node.value.equals(value))
            return node;

        TreeNode found = null;
        if (node.left != null)
            found = findNode(node.left, value);

        if (found == null && node.right != null)
            found = findNode(node.right, value);

        return found;
    }

    //Here I wanted to show, that I used static nested classes, we can discuss about implementation
    static class TreeNode<T> {

        T value;

        TreeNode left;

        TreeNode right;

        TreeNode(T value, TreeNode l, TreeNode r) {
            this.value = value;
            left = l;
            right = r;
        }

        TreeNode(T value) {
            this(value, null, null);
        }

        //Better to create something like  createNode(T s), but we don't need it
        static TreeNode createNode(String s) {
            return "#".equals(s) ? null : new TreeNode<>(s);
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
