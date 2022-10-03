package linkedlist.singlelinkedlist;

import linkedlist.Node;

import java.util.LinkedList;

public class SingleLinkedList {
    public Node head;

    public SingleLinkedList(Integer[] values) {
        Node head = new Node();
        Node tmp = head;
        for (Integer value : values) {
            tmp.next = new Node(value);
            tmp = tmp.next;
        }
        this.head = head;
    }

    static Node getTestNode() {
        return new SingleLinkedList(new Integer[]{1, 2, 3, 4}).head;
    }

    public void print() {
        Node tmp = this.head;
        LinkedList<Integer> values = new LinkedList<>();
        while (tmp.next != null) {
            values.add(tmp.next.value);
            tmp = tmp.next;
        }
        System.out.printf("链表：%s\n", values);
    }

    public static void main(String[] args) {
        new SingleLinkedList(new Integer[]{1, 2, 3, 4}).print();
    }
}
