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
    ArrayList<Integer> ans;
    public int maxPathSum(TreeNode root) {
        ans = new ArrayList<>();
        ans.add(root.val);
        
        dfs(root);
        
        return ans.get(0);
    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftMax = dfs(root.left);
        int rtMax = dfs(root.right);
        
        leftMax = Math.max(leftMax,0);
        rtMax = Math.max(rtMax,0);
        
        //compute Max path sum with split
        ans.set(0,Math.max(ans.get(0),root.val + leftMax + rtMax));
        
        //Compute max without the split
        return root.val + Math.max(leftMax,rtMax);
    }
}