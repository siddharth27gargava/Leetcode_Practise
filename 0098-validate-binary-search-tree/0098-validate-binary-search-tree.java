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
        if (root == null) {
            return true;
        }

        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer mmin, Integer mmax){
        if (root == null) {
            return true;
        }

        if ((mmin!=null && root.val <= mmin) || (mmax!=null && root.val >= mmax)) {
            return false;
        }

        return helper(root.left, mmin, root.val) && helper(root.right, root.val, mmax);
    }
}