package linkedlist.singleCircleLinkedList;

import linkedlist.Node;

public class SingleCircleLinkedList {
    public Node first;

    public SingleCircleLinkedList() {
    }

     public void add(int number) {
        if (number < 1) return;
        Node cur = null;
        for (int i = 0; i < number; i++) {
            if (i == 0) {
                first = new Node(i);
                first.next = first;
                cur = first;
            } else {
                Node newNode = new Node(i);
                newNode.next = first;
                cur.next = newNode;
                cur = newNode;
            }
        }
    }

    private void show() {
        Node cur = first;
        while (true) {
            if (cur.next == first) {
                break;
            }
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.add(10);
        singleCircleLinkedList.show();
    }
}
