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
    public ListNode partition(ListNode head, int x) {
        ListNode beforehead = new ListNode();
        ListNode afterhead = new ListNode();

        //when having a scenario where there are two new llnodes that you want to add on. Make sure to keep the original, and create a copy for ops
        ListNode beforeheadseries = beforehead;
        ListNode afterheadseries = afterhead;

        ListNode curr = head;

        while (curr!=null) {
            
            ListNode ahead = curr.next;

            if (curr.val < x) {
                beforeheadseries.next = curr;
                beforeheadseries = beforeheadseries.next;
            } else {
                afterheadseries.next = curr;
                afterheadseries = afterheadseries.next;
            }

            curr = ahead;
        }

        beforeheadseries.next = afterhead.next;
        afterheadseries.next = null;

        return beforehead.next;
    }
}