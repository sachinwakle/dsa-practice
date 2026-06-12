package TwoPointers;

public class LC_83_Remove_Duplicates_From_Sorted_List {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        head = null;
        while (right != null) {
            if (right.next != null && right.val == right.next.val) {
                right = right.next;
            } else {
                if (head == null) {
                    head = right;
                    left = right;
                } else {
                    left.next = right;
                    left = left.next;
                }
                right = right.next;
            }
        }
        return head;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val);
            System.out.print(" ");
            result = result.next;
        }
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
