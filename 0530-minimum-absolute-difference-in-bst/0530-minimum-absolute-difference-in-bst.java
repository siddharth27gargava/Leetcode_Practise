
import java.lang.module.ResolutionException;

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
    public int getMinimumDifference(TreeNode root) {
        // inorder traversal

        List<Integer> trav = getInOrder(root);

        int prev = Integer.MAX_VALUE;

        for (int i = 1; i < trav.size(); i++) {
            if ((Math.abs(trav.get(i) - trav.get(i - 1))) < prev) {
                prev = (Math.abs(trav.get(i) - trav.get(i - 1)));
            }
        }

        return prev;

    }

    public List<Integer> getInOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        helper(root, ans);
        return ans;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

}