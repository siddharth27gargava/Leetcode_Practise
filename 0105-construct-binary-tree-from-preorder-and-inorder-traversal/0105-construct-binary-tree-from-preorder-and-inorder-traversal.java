/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }
        
        return recbuild(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }
    
    public TreeNode recbuild(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder){
        
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = findPosition(inorder, preorder[preStart]);
        int numsleft_pre = mid - inStart; //used for creating preorder sub-arrays
        
        root.left = recbuild(preStart + 1, preStart + numsleft_pre, preorder, inStart, mid - 1, inorder);
        root.right = recbuild(preStart + numsleft_pre + 1, preEnd, preorder, mid + 1, inEnd, inorder);
        
        return root;
    }
    
    //find index value of num
    public int findPosition(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == num){
                return i;
            }
        }
        return -1;
    }
}