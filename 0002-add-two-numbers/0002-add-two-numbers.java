/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int v1 = 0;
        int v2 = 0;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                v1 = l1.val;
            } else {
                v1 = 0;
            }

            if (l2 != null) {
                v2 = l2.val;
            } else {
                v2 = 0;
            }
            int add = v1 + v2 + carry;
            carry = add / 10;
            add = add % 10;

            ListNode nn = new ListNode(add);
            curr.next = nn;

            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = null;
            }

            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = null;
            }
        }

        return dummy.next;
    }
}