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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listh = new ListNode();
        ListNode head = listh;
        
        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
                listh.next = list2;
                listh = listh.next;
                list2 = list2.next;
            } else{
                listh.next = list1;
                listh = listh.next;
                list1 = list1.next;
            }
        }
        
        if(list1 == null & list2 != null){
            listh.next = list2;
        }
        
        if(list2 == null & list1 != null){
            listh.next = list1;
        }
        
        return head.next;
    }
}