/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //1) Reach till half

        //Why does fast start from first.next
        ListNode fast = head.next;
        ListNode slow = head;

        // it is && and not || because we have to ensure both cases are true
        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //2) Cutoff the half
        ListNode shead = slow.next;
        slow.next = null;

        //3) reverse the second half
        ListNode curr = shead;
        ListNode prev = null;

        while (curr != null) {
            ListNode ahead = curr.next;

            curr.next = prev;

            prev = curr;
            curr = ahead;
        }

        shead = prev;

        //4) Join alternatively
        ListNode fhead = head;

        //ListNode ans = null;

        while (shead != null) {
            ListNode tm1 = fhead.next;
            ListNode tm2 = shead.next;

            fhead.next = shead;
            shead.next = tm1;

            fhead = tm1;
            shead = tm2;
        }

        
    }
}