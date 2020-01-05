package com.tinker.algorithms;

public class ListRelated {

    public static void main(String[] args) {
        Node node = null;
        Node node0 = new Node(1);
        Node node1 = new Node(3);
        Node node11 = new Node(1);
        Node node111 = new Node(1);
        Node node2 = new Node(5);
        Node node3 = new Node(7);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
//        Node res = removeAllNode(node0, 1);
//        while(res!=null){
//            System.out.println(res.val);
//            res = res.next;
//        }
//        reversePrint(node0);
//        Node d0 = new Node(2);
//        Node d1 = new Node(4);
//        d0.next = d1;
//        Node res = mergeSortedList(node0, d0);
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
        Node d0 = new Node(2);
        Node d1 = new Node(4);
        d0.next = d1;
        d1.next = node3;
//        Node res = firstCommonNode(node0, d0);
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }


    }

    /**
     * 寻找两个链表的第一个公共节点；
     * @param head1
     * @param head2
     * @return
     */
    private static Node firstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int len1 = 0, len2 = 0;
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        cur1 = head1;
        cur2 = head2;
        if (len1 > len2) {
            int k = len1 - len2;
            while (k > 0) {
                cur1 = cur1.next;
                k--;
            }
        } else {
            int k = len2 - len1;
            while (k > 0) {
                cur2 = cur2.next;
                k--;
            }
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    private static Node reverseList(Node head) {
        Node one = null;// 翻转后的链表的头结点；
        Node two = head;// 未翻转的链表部分的头结点；
        Node three = null;// 翻转过程中链表断开时，未翻转的链表部分的头结点；
        while (two != null) {
            three = two.next;
            two.next = one;
            one = two;
            two = three;
        }
        return one;
    }

    /**
     * 合并两个有序的链表，最终结果链表有序
     * @param head1
     * @param head2
     * @return
     */
    private static Node mergeSortedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Node dummy = new Node();// 合并后的链表的头结点，返回的结果中不包括第一个节点，为了逻辑方便
        Node cur = dummy;//指向合并后的链表的尾结点；
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        // 后边这一部分不能少，因为合并后的链表会以较短的链表的尾结点处终止，
        // 那么较长的链表多出的节点并没有追加到合并后的链表上，所以还需要追加上去
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dummy.next;
    }

    private static void reversePrint(Node head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head.val);
    }

    private static Node removeFirstNode(Node head, int val) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node();
        dummy.next = head;
        Node pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;//移除之后，直接 break；即只移除第一个 val 相等的节点；
            } else {
                pre = head;
                head = head.next;
            }
        }
        return dummy.next;
    }

    private static Node removeAllNode(Node head, int val) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node();
        dummy.next = head;
        Node pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return dummy.next;
    }


    private static class Node {
        private Node next;
        private int val;

        private Node() {
        }

        private Node(int val) {
            this.val = val;
        }
    }
}
