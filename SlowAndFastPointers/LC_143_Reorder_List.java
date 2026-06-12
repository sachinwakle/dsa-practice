package SlowAndFastPointers;

public class LC_143_Reorder_List {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;
        ListNode next = curr.next;

        while (true) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next == null) {
                break;
            }
            next = next.next;
        }

        ListNode left = head;
        ListNode right = prev;
        ListNode trav = left;

        while (left != right && right != null) {
            left = left.next;
            trav.next = right;
            right = right.next;
            trav = trav.next;
            trav.next = left;
            trav = trav.next;
        }

         trav.next = null;

    }
}
