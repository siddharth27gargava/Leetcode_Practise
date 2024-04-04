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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = inOrder(root);

        int ans = res.get(k-1);

        return ans;
    }

    public List<Integer> inOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }

        helper(root,ans);

        return ans;
    }

    public void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
}