package SlowAndFastPointers;


public class LC_234_Palindrome_Linked_List {
    public static boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode curr = null;
        ListNode next = null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        curr = slow;
        next = slow.next;

        while (true) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next == null) {
                break;
            }
            next = next.next;
        }

        ListNode right = prev;
        ListNode left = head;
        while (left != right && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean res = isPalindrome(head);
        System.out.println(res);

        
    }
}

// Definition for singly-linked list.

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }
