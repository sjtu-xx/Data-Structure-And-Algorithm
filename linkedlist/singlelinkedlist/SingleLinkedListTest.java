package linkedlist.singlelinkedlist;

import linkedlist.Node;

import java.util.Deque;
import java.util.LinkedList;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        reverseList(SingleLinkedList.getTestNode()); // 会对已有链表产生影响
        reversePrint(SingleLinkedList.getTestNode());
    }

    private static void reverseList(Node head) {
        // 反转链表
        Node.print(head);
        if (head.next == null) {
            return;
        }
        Node needInsertNode = head.next;
        Node reverseHead = new Node();
        while (needInsertNode != null) {
            Node tmp = needInsertNode.next;
            needInsertNode.next = reverseHead.next;
            reverseHead.next = needInsertNode;
            needInsertNode = tmp;
        }
        Node.print(reverseHead);
    }

    public static void reversePrint(Node head) {
        // 方法1：先反转再打印。会破会链表的结构
        // 方法2：Stack
        if (head.next == null) {
            return;
        }
        Node tmp = head;
        Deque<Integer> values = new LinkedList<>();
        while (tmp.next != null) {
            values.push(tmp.next.value);
            tmp = tmp.next;
        }

        while (!values.isEmpty()) {
            System.out.println(values.pop());
        }
    }
}
