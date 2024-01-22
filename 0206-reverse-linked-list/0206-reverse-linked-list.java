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
    public ListNode reverseList(ListNode head) {
        //no need to connect initially prev to curr
        ListNode curr = head;
        ListNode prev = null;
        
        //since we're going to keep on moving till we reach the last node, when curr becomes, the new head is prev since it is behind curr
        while (curr!=null) {
            //need this because we have to store the value in-order to shift curr to ahead  
            ListNode ahead = curr.next;

            //switch the direction
            curr.next = prev;

            //update the pointers
            prev = curr;
            curr = ahead;
        }

        //explained 
        return prev;
    }
}