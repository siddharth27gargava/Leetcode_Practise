/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(0);
        ListNode* curr = dummy;
        int carry = 0;
        int val1 = 0;
        int val2 = 0;
        
        while(l1!=NULL || l2!=NULL || carry!=0){
            
            //Extract L1
            if(l1!=NULL){
                val1 = l1->val;
            } else {
                val1 = 0;
            }
            
            //Extract l2
            if(l2!=NULL){
                val2 = l2->val;
            } else{
                val2 = 0;
            }
            
            int val = val1 + val2 + carry;
            carry = val/10;
            int numadd = val%10;
            
            curr->next = new ListNode(numadd);
            curr = curr->next;
            
            //Extract L1
            if(l1!=NULL){
                l1 = l1->next;
            } else {
                l1 = NULL;
            }
            
            //Extract l2
            if(l2!=NULL){
                l2 = l2->next;
            } else{
                l2 = NULL;
            }
            
        }
        
        return dummy->next;
    }
};