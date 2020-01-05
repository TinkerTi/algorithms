package com.tinker.algorithms.print_list_reversely;

import com.tinker.algorithms.merger_order_list.MergeOrderedList;

public class PrintListReversely {


    private static void printListInReverseOrder(Node head){
        if(head==null)
            return;
        printListInReverseOrder(head.next);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node11 = new Node(3);
        Node node12 = new Node(5);
        head1.next = node11;
        node11.next = node12;
        node12.next = null;
        printListInReverseOrder(head1);
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
