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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        //Identify all the nodes with values
        while(curr!=null){
            ListNode nxt = curr.next;
            if(curr.val == val){
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            
            curr = nxt;
        }
        
        return dummy.next;
    }
}