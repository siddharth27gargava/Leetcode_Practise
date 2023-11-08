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
    public int maxPathSum(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(root.val);
        
        dfs(root, res);
        
        return res.get(0);
    }
    
    public int dfs(TreeNode root, ArrayList<Integer> res){
        if (root == null){
            return 0;
        }
        
        int leftMax = dfs(root.left, res);
        int rtMax = dfs(root.right, res);
        
        leftMax = Math.max(0, leftMax);
        rtMax = Math.max(0, rtMax);
        
        res.set(0,Math.max(res.get(0), leftMax + rtMax + root.val));
        
        return root.val + Math.max(leftMax, rtMax);
    }
}