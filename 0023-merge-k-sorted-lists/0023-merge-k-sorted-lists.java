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
    public ListNode mergeKLists(ListNode[] lists) {
        //Priority queue
        //Linkedlist
        
        //Initialisation
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        if(lists == null){
            return null;
        }
        
        //PQ
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode ln : lists){
            if(ln!=null){
                pq.add(ln);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode rmv = pq.remove();
            curr.next = rmv;
            curr = curr.next;
            rmv = rmv.next;
            if(rmv!=null){
                pq.add(rmv);
            }
        }
        
        return dummy.next;
    }
}