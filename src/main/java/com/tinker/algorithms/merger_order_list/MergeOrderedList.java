package com.tinker.algorithms.merger_order_list;

public class MergeOrderedList {


    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node11 = new Node(3);
        Node node12 = new Node(5);
        Node head2 = new Node(2);
        Node node21 = new Node(4);
        Node node22 = new Node(6);
        Node node23 = new Node(8);
        Node node24 = new Node(10);
        head1.next = node11;
        node11.next = node12;
        node12.next = null;

        head2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node24.next = node24;

//        Node head = merge1(head1, head2);

        Node head = mergeTwoLists(head1, head2);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node merge_recursively(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head = new Node(-1);
        if (head1.value <= head2.value) {
            head.next = head1;
            head1.next = merge_recursively(head1.next, head2);
        } else {
            head.next = head2;
            head2.next = merge_recursively(head1, head2.next);
        }
        return head.next;
    }

    // 有三个指针
    private static Node merge1(Node head1, Node head2) {
        Node current = new Node(0);
        Node head = current;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                current.next = head1;
                current = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = head2;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }

        return head.next;
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head = null;
        Node tail = null;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                if (head == null) {
                    head = head1;
                } else {
                    tail.next = head1;
                }
                tail = head1;
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = head2;
                } else {
                    tail.next = head2;
                }
                tail = head2;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }

        return head;
    }


    public static  Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node p1 = l1;
        Node p2 = l2;
        Node head = new Node(0);
        Node current = head;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                current.next = p1;
                p1 = p1.next;
                current = current.next;
            } else {
                current.next = p2;
                p2 = p2.next;
                current = current.next;
            }
        }
        if (p1 != null) {
            current.next = p1;
        }
        if (p2 != null) {
            current.next = p2;
        }
        return head.next;
    }


}
