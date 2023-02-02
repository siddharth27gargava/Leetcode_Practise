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
         PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        
        for(ListNode ln : lists){
            if (ln!=null){
                pq.add(ln);
            }
        }
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        
        while (!pq.isEmpty()){
            ListNode node = pq.remove();
            
            prev.next = node;
            prev = prev.next;
            node = node.next;
            
            if (node!=null){
                pq.add(node);
            }
        }
        
        return dummy.next;
    }
    
}