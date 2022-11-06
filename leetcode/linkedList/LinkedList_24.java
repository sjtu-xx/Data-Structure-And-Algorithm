package leetcode.linkedList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedList_24 {
    // 时间100%，空间30%
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        ListNode newHead = swapPairs(tmp.next);
        tmp.next = head;
        head.next = newHead;
        return tmp;
    }

    // 时间100%， 空间 97%
    public ListNode swapPairs2(ListNode head) {
        ListNode preNode = new ListNode(0, head);
        ListNode tmpNode = preNode;
        while (tmpNode.next != null && tmpNode.next.next != null) {
            ListNode tmp = tmpNode.next.next;
            tmpNode.next.next = tmp.next;
            tmp.next = tmpNode.next;
            tmpNode.next = tmp;
            tmpNode = tmp.next;
        }
        return preNode;
    }
}
