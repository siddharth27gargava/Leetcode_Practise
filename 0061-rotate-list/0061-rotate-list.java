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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        //idea: keep reaching till the second last and last ListNode
        //remove secondlast and last
        //attach it to head
        //update the head and k
        while (k > 0) {
            ListNode curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }

            ListNode secLast = curr;
            ListNode last = curr.next;

            //severe connection
            secLast.next = null;
            last.next = head;

            head = last;
            k--;
        }

        return head;
    }
}