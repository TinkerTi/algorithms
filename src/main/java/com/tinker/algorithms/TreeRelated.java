package com.tinker.algorithms;

import java.util.LinkedList;
import java.util.List;

public class TreeRelated {

    public static void main(String[] args) {
//        testConstructTree();
//        System.out.println(testSubTree());
//        print(testReverseTree());
//        testIsSearchTree();
//        testTreeSumPath();
//        testTreeHeight();
        testBalanceTree();
    }

    private static TreeNode testReverseTree() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        return reverseTree(treeNode0);
    }

    private static boolean testSubTree() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;

        TreeNode treeNode00 = new TreeNode(0);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode44 = new TreeNode(4);
        treeNode11.left = treeNode33;
        treeNode11.right = treeNode44;
        treeNode44.left = treeNode00;
        return subTree(treeNode0, treeNode11);
    }

    private static void testConstructTree() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = constructTree(pre, mid, 0, pre.length - 1, 0, mid.length - 1);
        printTreeByLevel(root);
    }

    private static void testIsSearchTree() {
        int[] pre = {5, 7, 6, 8, 1, 10, 8};
        System.out.println(isSearchTree(pre, 0, pre.length - 1));
    }

    private static void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
    }

    private static void testTreeSumPath() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(6);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeSumPath(treeNode0, 10, 0, new LinkedList<>());
    }

    private static void testTreeHeight() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(6);
        TreeNode treeNode10 = new TreeNode(6);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode9.left = treeNode10;
        System.out.println(treeHeight(treeNode0, 0));
    }

    private static void testBalanceTree() {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(6);
        TreeNode treeNode10 = new TreeNode(6);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode9.left = treeNode10;
        balanceTree(treeNode0, 0);
        System.out.println(isBalanced);
    }

    private static boolean isBalanced = true;
    private static int balanceTree(TreeNode root, int h) {
        if (root == null) {
            return h;
        }
        h = h + 1;
        int left = treeHeight(root.left, h);
        int right = treeHeight(root.right, h);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right);
    }

    private static int treeHeight(TreeNode root, int h) {
        if (root == null) {
            return h;
        }
        h = h + 1;
        int left = treeHeight(root.left, h);
        int right = treeHeight(root.right, h);
        return Math.max(left, right);
    }

    /**
     * 路径（根节点到叶子节点的路径）上的节点值之和等于某个目标值
     *
     * @param root
     * @param target
     * @param sum
     * @param path
     */
    private static void treeSumPath(TreeNode root, int target, int sum, LinkedList<TreeNode> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                path.offerLast(root);
                printPath(path);
                path.pollLast();
                return;
            }
        }
        path.offerLast(root);
        sum = sum + root.val;
        if (root.left != null) {
            treeSumPath(root.left, target, sum, path);
        }
        if (root.right != null) {
            treeSumPath(root.right, target, sum, path);
        }
        path.pollLast(); // 这一步必不可少，当检查完节点的左右子树之后，需要将此节点从 path 中移除，
        // 因为这个方法执行结束之后，与此节点在无关系，开始与此节点无关的其他路径探索，所以
        // 与此节点有关的痕迹也必须清除，path 中存在节点相关的痕迹的，需要移除；
        sum -= root.val;
    }

    private static void printPath(List<TreeNode> path) {
        for (TreeNode item : path) {
            System.out.print(item.val);
        }
        System.out.println("");
    }

    /**
     * 判断一数组，是否为二叉搜索树的后序遍历结果
     *
     * @param data
     * @param start
     * @param end
     * @return
     */
    private static boolean isSearchTree(int[] data, int start, int end) {
        if (data == null) {
            return false;
        }
        if (start < 0 || end >= data.length) {
            return false;
        }
        if (end == start) {
            return true;
        }
        int root = data[end];
        int idx = findSepPoint(data, start, end);
        boolean res1 = true, res2 = true;
        for (int i = idx; i <= end; i++) {
            if (data[i] < root) {
                return false;
            }
        }
        if (idx > start) {
            res1 = isSearchTree(data, start, idx - 1);
        }
        if (idx < end) {
            res2 = isSearchTree(data, idx, end - 1);
        }
        return res1 && res2;
    }

    private static int findSepPoint(int[] data, int start, int end) {
        int res = end;
        for (int i = start; i <= end; i++) {
            if (data[i] >= data[end]) {
                res = i;
                break; // 找到结果之后，一定要结束循环；
            }
        }
        return res;
    }

    /**
     * 二叉树的镜像
     *
     * @param root
     * @return
     */
    private static TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = reverseTree(root.right);
        root.right = reverseTree(tmp);
        return root;
    }

    /**
     * 判断 B 是否为 A 的子树
     *
     * @param root1
     * @param root2
     * @return
     */
    // 判断两个树A、B，B是否为 A的子树，
    // 分为两步，先判断以 A 的根节点为根节点的树，与 B 是否结构相同，相同则是，
    // 不相同则，分别以A的左右子树为根节点，判断其是否与 B 有相同结构；
    private static boolean subTree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        boolean res = false;
        if (judge(root1, root2)) {
            res = true;
        } else {
            res = subTree(root1.left, root2) || subTree(root1.right, root2);
        }
        return res;
    }

    private static boolean judge(TreeNode root1, TreeNode root2) {
        //递归的终止条件需要注意；
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        boolean res = false;
        if (root1.val == root2.val) {
            res = judge(root1.left, root2.left) && judge(root1.right, root2.right);
        }
        return res;
    }

    /**
     * 水平打印二叉树
     *
     * @param root
     */
    private static void printTreeByLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offerLast(root);
        TreeNode cur = null;
        while (!nodes.isEmpty()) {
            cur = nodes.pollFirst();
            System.out.println(cur.val);
            if (cur.left != null) {
                nodes.offerLast(cur.left);
            }
            if (cur.right != null) {
                nodes.offerLast(cur.right);
            }
        }
    }

    /**
     * 根据前序遍历和中序遍历数组，构造二叉树；
     *
     * @param data1
     * @param data2
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */

    // 四个索引分别记录，各个子树的前序和中序的起始和终止的位置，
    // 根据中序数据，计算左右子树的节点个数，以此确定左右子树在两个数组中的起始和终止位置；
    //注意终止条件，左右子树可能节点个数为0；
    private static TreeNode constructTree(int[] data1, int[] data2, int start1, int end1, int start2, int end2) {
        if (end1 - start1 == 0) {
            return new TreeNode(data1[start1]);
        }
        if (end2 - start2 == 0) {
            return new TreeNode(data2[start2]);
        }
        TreeNode root = new TreeNode(data1[start1]);// 根节点的值为前序遍历的第一个值；
        int idx = findRoot(data1, data2, start1, end1, start2, end2);
        int leftLen = idx - start2;
        int rightLen = end2 - idx;
        if (leftLen > 0)//只有左子树节点存在才会进步一去确定左子树的节点结构
            root.left = constructTree(data1, data2, start1 + 1, start1 + leftLen, start2, start2 + leftLen - 1);
        if (rightLen > 0)//只有右子树节点存在才会进一步确定右子树的节点结构；
            root.right = constructTree(data1, data2, start1 + leftLen + 1, end1, idx + 1, end2);
        return root;
    }

    private static int findRoot(int[] data1, int[] data2, int start1, int end1, int start2, int end2) {
        int idx = -1;
        for (int i = start2; i <= end2; i++) {
            if (data1[start1] == data2[i]) {
                idx = i;
            }
        }
        return idx;
    }

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        private TreeNode() {
        }

        private TreeNode(int val) {
            this.val = val;
        }
    }
}
