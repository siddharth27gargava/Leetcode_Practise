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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val);
    }

    //keeping track of current node and maxval
    public int dfs(TreeNode root, int maxVal){
        int result = 0;
        //purpose of resut is different - just check if it should be 1 or 0

        if (root == null) {
            return 0;
        }

        if (root.val >= maxVal) {
            result = 1;
        } else{
            result = 0;
        }

        maxVal = Math.max(root.val, maxVal);

        //Rec work
        result += dfs(root.left, maxVal);
        result += dfs(root.right, maxVal);

        return result;
    }
}