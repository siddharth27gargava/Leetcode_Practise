/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // traverse only once then O(n)
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int v1, v2;

        if (root1 != null) {
            v1 = root1.val;
        } else {
            v1 = 0;
        }

        if (root2 != null) {
            v2 = root2.val;
        } else {
            v2 = 0;
        }

        TreeNode root = new TreeNode(v1 + v2);

        root.left = mergeTrees((root1 != null && root1.left != null) ? root1.left : null, 
        (root2 != null && root2.left != null) ? root2.left : null);

        root.right = mergeTrees((root1 != null && root1.right != null) ? root1.right : null, 
        (root2 != null && root2.right != null) ? root2.right : null);

        return root;

    }
}