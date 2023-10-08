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
        //Create a curr node
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        //Priority q
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        
        //Add in pq
        for(ListNode ln : lists){
            if(ln!=null){
                pq.add(ln);
            }
        }
        
        //Merge List
        while(!pq.isEmpty()){
            ListNode node = pq.remove();
            
            curr.next = node;
            curr = curr.next;
            node = node.next;
            
            if(node!=null){
                pq.add(node);
            }
        }
        
        return dummy.next;
        
    }
}