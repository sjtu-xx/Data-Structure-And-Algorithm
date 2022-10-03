package linkedlist;

import java.util.LinkedList;

public class Node {
    public Node next;
    public Integer value;
    public Node() {

    }
    public Node(Integer value) {
        this.value = value;
    }

    public static void print(Node startNode) {
        Node tmp = startNode;
        LinkedList<Integer> values = new LinkedList<>();
        while (tmp.next != null) {
            values.add(tmp.next.value);
            tmp = tmp.next;
        }
        System.out.printf("链表：%s\n", values);
    }
}
