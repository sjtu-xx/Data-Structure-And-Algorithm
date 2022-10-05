package linkedlist.singleCircleLinkedList;

import linkedlist.Node;

import java.awt.print.Printable;

public class JosephuProblem {
    public static void main(String[] args) {
        int start = 1, kill_count = 2, total = 5;
        SingleCircleLinkedList childrens = new SingleCircleLinkedList();
        childrens.add(total);
        Node first = childrens.first;
        Node helper = first;
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        for (int i = 0; i < start - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        while (true) {
            if (first == first.next) {
                System.out.println(first.value + 1);
                break;
            }
            for (int i = 0; i < kill_count - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first.value + 1);
            first = first.next;
            helper.next = first;
        }

    }

}
