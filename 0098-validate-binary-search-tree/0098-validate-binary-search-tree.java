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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return helper(root,null,null);
        
    }
    
    public boolean helper(TreeNode node, Integer mmin, Integer mmax){
        if(node == null){
            return true;
        }
        
        if((mmin!=null && node.val <= mmin) ||(mmax!=null && node.val >= mmax)){
            return false;
        }
        
        return helper(node.left,mmin,node.val) && helper(node.right,node.val,mmax);
    }
}