package com.gukulkan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTreeFactory {

    public static Tree buildTree (InputStreamReader reader){
        Tree<String> tree = new Tree<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String thisLine;

        List<Tree.TreeNode> nodes = new ArrayList<>();

        try {
            while ((thisLine = bufferedReader.readLine()) != null) {
                System.out.println(thisLine);
                String[] strings = thisLine.split(",");
                Tree.TreeNode treeNodeForAdd = new Tree.TreeNode<>(
                        strings[0],
                        Tree.TreeNode.createNode(strings[1]),
                        Tree.TreeNode.createNode(strings[2]));
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
}
