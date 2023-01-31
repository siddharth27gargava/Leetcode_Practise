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
        ListNode slow = head;
        ListNode fast = head.next;
        //getting the second halh
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode second = slow.next;
        //cutting the halves
        slow.next = null;
        
        //reversing the second half
        ListNode prev = null;
        while(second!=null){
            ListNode tmp = second.next;
            
            second.next = prev;
            prev = second;
            second = tmp;
        }
        second = prev;
        //merge the two lists
        ListNode first = head;
        
        while(second!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            
            first.next = second;
            second.next = tmp1;
            
            first = tmp1;
            second = tmp2;
        }
    }
}