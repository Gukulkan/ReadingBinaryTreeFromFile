package com.gukulkan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tree<T> {

    private TreeNode root;

    public boolean insert(T name, String left, String right){
        return insert(new TreeNode<>(
                name,
                createNodeFromString(left),
                createNodeFromString(right)));
    }

    private boolean insert(TreeNode node){
        TreeNode toInsert = insert(root, node);

        if(toInsert == null)
            return false;

        root = toInsert;

        return true;
    }

    private TreeNode insert(TreeNode r, TreeNode toInsert)
    {
        if (r == null)
            return toInsert;

        if (toInsert.right !=null && toInsert.right.value.equals(r.value)) {
            toInsert.right = r;
            return toInsert;
        }

        if (toInsert.left !=null && toInsert.left.value.equals(r.value)) {
            toInsert.left = r;
            return toInsert;
        }

        if (r.right != null && r.right.value.equals(toInsert.value)) {
            r.right = toInsert;
            return r;
        }

        if (r.left != null && r.left.value.equals(toInsert.value)){
            r.left = toInsert;
            return r;
        }

        if(r.right != null){
            return insert(r.right, toInsert);
        } else if(r.left != null){
            return insert(r.left, toInsert);
        }

        return null;
    }

    private void insertAll(List<TreeNode> in){
        int inSize = in.size();
        List<TreeNode> out = new ArrayList<>();

        for (TreeNode treeNode : in){
            if(!this.insert(treeNode)){
                out.add(treeNode);
            }
        }

        if(out.size() > 0 && inSize != out.size())
            insertAll(out);
        else if(inSize == out.size())
            throw new RuntimeException("There incorrect nodes in file");
        in.clear();
    }

    public static Tree buildTree (InputStreamReader reader){
        Tree tree = new Tree();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String thisLine;

        List<TreeNode> nodes = new ArrayList<>();

        try {
            while ((thisLine = bufferedReader.readLine()) != null) {
                System.out.println(thisLine);
                String[] strings = thisLine.split(",");
                TreeNode treeNodeForAdd = new TreeNode<>(
                        strings[0],
                        createNodeFromString(strings[1]),
                        createNodeFromString(strings[2]));
                if(!nodes.stream()
                        .filter(node -> node.value.equals(strings[0]))
                        .collect(Collectors.toList())
                        .isEmpty())
                    throw new RuntimeException("File has duplicated roots");

                nodes.add(treeNodeForAdd);
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            throw new RuntimeException("Incorrect input file");
        }

        if(nodes.size() > 0)
            tree.insertAll(nodes);

        return tree;
    }

    private static TreeNode createNodeFromString(String s){
        return "#".equals(s)? null : new TreeNode<>(s);
    }

    static class TreeNode<T> {

        T value;

        TreeNode left;

        TreeNode right;

        TreeNode(T value, TreeNode l, TreeNode r)
        {
            this.value = value;
            left = l;
            right = r;
        }

        TreeNode(T value)
        {
            this(value, null, null);
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
