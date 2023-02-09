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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int lht = diameterOfBinaryTree(root.left);
        int rht = diameterOfBinaryTree(root.right);
        
        int ht = height(root.left) + height(root.right) + 2;
        
        int max = Math.max(ht,Math.max(lht,rht));
        
        return max;
    }
    
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        
        int lt = height(root.left);
        int rt = height(root.right);
        
        int max = Math.max(rt,lt) + 1;
        
        return max;
    }

}