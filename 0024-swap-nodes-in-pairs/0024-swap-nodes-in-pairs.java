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
    public ListNode swapPairs(ListNode head) {
        if((head == null) || (head.next == null)){
            return head;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        
        //swap : we keep on moving  from 1 as head; we move 3 as head now. This will return 3 as head based on base case
        //then first.next is now pointing to head; which means 4 is pointing to 3
        //second which is now 
        first.next = swapPairs(second.next);
        second.next = first;
        
        return second;
    }
}