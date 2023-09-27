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
        //Get half
        ListNode slow = head;
        ListNode fast = head.next;
        int counter = 0;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            counter++;
        }
        
        // ListNode first = head;
        // ListNode headfirst = head;
        // //Find the first half
        // while(counter > 0){
        //     first = first.next;
        //     counter--;
        // }
        
        //Cut the halves
        ListNode second = slow.next;
        slow.next = null;
        
        //Reverse the second half
        ListNode midprev = null;
        
        while(second!=null){
            ListNode midahead = second.next;
            
            second.next = midprev;
            
            midprev = second;
            second = midahead;
        }
        second = midprev;
        
        //Add the lls
        ListNode first = head;
        
        while(second!=null){
            ListNode tm1 = first.next;
            ListNode tm2 = second.next;
            
            first.next = second;
            second.next = tm1;
            
            first = tm1;
            second = tm2;
        }
        
    }
}