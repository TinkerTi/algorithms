package com.tinker.algorithms.print_tree_node_path;

import com.tinker.algorithms.construct_binary_tree.ConstructBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PrintTreeNodePath {

    private static void printTreeNodePath(
            TreeNode root, int key, int sum, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        sum = sum + root.value;
        list.add(root);
        if (sum == key && isLeaf(root)) {
            print(list);
        }
        printTreeNodePath(root.left, key, sum, list);
        printTreeNodePath(root.right, key, sum, list);
        list.remove(list.size() - 1);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void print(List<TreeNode> list) {
        System.out.println("[");
        for (TreeNode node : list) {
            System.out.println(node.value);
        }
        System.out.print("]");
        System.out.println(" ");
    }

    private static class TreeNode {
        private int value;
        TreeNode left;
        TreeNode right;

        private TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(12);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode treeNode11 = new TreeNode(4);
        TreeNode treeNode12 = new TreeNode(7);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;
        printTreeNodePath(treeNode, 22, 0, new ArrayList<>());
    }
}
