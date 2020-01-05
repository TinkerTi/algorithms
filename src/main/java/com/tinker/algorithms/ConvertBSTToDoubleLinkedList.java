package com.tinker.algorithms;

public class ConvertBSTToDoubleLinkedList {

    private static TreeNode converse(TreeNode root,boolean isLeft){
        if(root==null){
            return null;
        }
        TreeNode left=converse(root.left,true);
        if(left!=null){
            left.right=root;
        }
        root.left=left;
        TreeNode right=converse(root.right,false);
        if(right!=null){
            right.left=root;
        }
        root.right=right;
        if(isLeft){
            if(right!=null){
                return right;
            }else {
                return root;
            }
        }else {
            if(left!=null){
                return left;
            }else
                return root;
        }

    }

    public static void main(String[] args){
        TreeNode treeNode0=new TreeNode(0);
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        treeNode1.left=treeNode0;
        treeNode1.right=treeNode2;
        treeNode3.left=treeNode1;
        treeNode3.right=treeNode5;
        treeNode5.left=treeNode4;
        treeNode5.right=treeNode6;
        TreeNode result=converse(treeNode3,true);
        while(result!=null){
            System.out.println(result.val);
            result=result.left;
        }
    }



    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(){}
        private TreeNode(int value){
            val=value;
        }
    }
}
