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
    
    public class Result{
        TreeNode prev;
        int ans;
        
        public Result(TreeNode prev, int ans){
            this.prev = prev;
            this.ans = ans;
        }
    }
    
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Result res = new Result(null,Integer.MAX_VALUE);
        // TreeNode prev = null;
        // int res = Integer.MAX_VALUE;
        
        helper(res,root);
        
        return res.ans;
    }
    
    public void helper(Result res, TreeNode root){
        if(root == null){
            return;
        }
        
        helper(res,root.left);
        
        if(res.prev!=null){
            res.ans = Math.min(res.ans, root.val - res.prev.val);
        }
        
        res.prev = root;
        
        helper(res,root.right);
    }
}