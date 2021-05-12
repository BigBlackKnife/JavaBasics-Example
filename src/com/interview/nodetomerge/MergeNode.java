package com.interview.nodetomerge;

/**
 * @author Blaife
 * @description 链表合并
 * @date 2021/5/11 22:18
 */
class Node {
    int data;
    Node next;
}

public class MergeNode {
    public static Node Merge(Node head1 , Node head2) {
        //递归结束条件
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //合并后的链表
        Node head = null;
        if (head1.data > head2.data) {
            //把head较小的结点给头结点
            head = head2;
            //继续递归head2
            head.next = Merge(head1, head2.next);
        } else {
            head = head1;
            head.next = Merge(head1.next, head2);
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 1;
        Node node2 = new Node();
        node2.data = 2;
        Node node3 = new Node();
        node3.data = 3;
        Node node4 = new Node();
        node4.data = 4;
        Node node5 = new Node();
        node5.data = 5;
        node1.next = node3;
        node3.next = node5;
        node2.next = node4;

        Node headResult = Merge(node1, node2);
        while(headResult != null) {
            System.out.println(headResult.data);
            headResult = headResult.next;
        }
    }
}