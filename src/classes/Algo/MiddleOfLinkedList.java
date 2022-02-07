package classes.Algo;

import classes.utill.ListNode;

import javax.swing.plaf.InsetsUIResource;

public class MiddleOfLinkedList {

    public void solve() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        //ListNode three = new ListNode(3);
        //ListNode four = new ListNode(4);
        //ListNode five = new ListNode(5);
        //ListNode six = new ListNode(6);

        head.next = two;
        //two.next = three;
        //three.next = four;
        //four.next = five;
        //five.next = six;

        ListNode result = middleNode(head);
        System.out.println(result.value);
    }

    private ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
