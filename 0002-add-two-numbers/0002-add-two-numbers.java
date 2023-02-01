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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int v1, v2 = 0;
            if(l1!=null){
                v1 = l1.val;
            } else {
                v1 = 0;
            }
            
            if(l2!=null){
                v2 = l2.val;
            } else {
                v2 = 0;
            }
            
            //new digit
            int val = v1+v2+carry;
            
            carry = val/10;
            val = val % 10;
            curr.next = new ListNode(val);
            
            //update pointers
            curr = curr.next;
            if(l1!=null){
                l1 = l1.next;
            } else {
                l1 = null;
            }
            
            if(l2!=null){
                l2 = l2.next;
            } else {
                l2 = null;
            }
        }
        
        return dummy.next;
    }
}