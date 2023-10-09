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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = null;
        
        int count = 0;
        
        //Reverse
        while(curr!=null && count < k){
            ahead = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = ahead;
            count++;
        }
        
        //Recursion
        if(ahead!=null && sizeLL(ahead) >= k){
            head.next = reverseKGroup(ahead,k);
        } else {
            head.next = ahead;
        }
        
        return prev;
    }
    
    public int sizeLL(ListNode head){
        if(head == null){
            return 0;
        }
        
        if(head.next == null){
            return 1;
        }
        int p = 0;
        
        ListNode current = head;
        while(current!=null){
            current = current.next;
            p++;
        }
        
        return p;
    }
}