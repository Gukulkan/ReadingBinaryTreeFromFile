package com.gukulkan;

public class TreeNode {

    String name;

    TreeNode left;

    TreeNode right;

    public TreeNode(String name, TreeNode l, TreeNode r)
    {
        this.name = name;
        left = l;
        right = r;
    }

    public TreeNode(String name)
    {
        this(name, null, null);
    }


}
