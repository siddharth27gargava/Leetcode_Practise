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
    public TreeNode invertTree(TreeNode root) {
        //Base-work
        if(root == null){
            return null;
        }
        
        //Rec work
        TreeNode leftT = invertTree(root.left);
        TreeNode rightT = invertTree(root.right);
        
        //Swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        return root;
        
    }
}