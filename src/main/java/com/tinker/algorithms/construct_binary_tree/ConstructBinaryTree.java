package com.tinker.algorithms.construct_binary_tree;

import javax.transaction.TransactionRequiredException;

public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = constructBinaryTree(pre, mid, 0, 0, pre.length);
        print(root);
    }

    private static void print(TreeNode root) {
        if (root != null) {

            print(root.left);
            System.out.println(root.value);
            print(root.right);
        }
    }

    private static TreeNode constructBinaryTree(
            int[] pre, int[] mid, int preStart, int midStart, int length) {
        if (length == 0)
            return null;
        if (length == 1) {
            return new TreeNode(pre[preStart]);
        }
        int root = pre[preStart];
        int rootInMidIndex = find(mid, root);
        int leftLength = rootInMidIndex - midStart;
        int rightLength=length-leftLength-1;
        TreeNode treeNode = new TreeNode(root);
        treeNode.left = constructBinaryTree(pre, mid, preStart + 1, midStart, leftLength);
        treeNode.right = constructBinaryTree(pre, mid, preStart + leftLength + 1, rootInMidIndex + 1, rightLength);
        return treeNode;
    }

    private static int find(int[] data, int key) {
        int i = 0;
        for (; i < data.length; i++) {
            if (key == data[i]) {
                break;
            }
        }
        return i;
    }

    private static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int value) {
            this.value = value;
        }
    }
}
