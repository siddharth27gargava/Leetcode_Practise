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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        long sum = 0;
        

        if(root == null){
            return ans;
        }

        Deque<TreeNode> q = new LinkedList<>();

        q.addLast(root);

        while(!q.isEmpty()){
            int qs = q.size();
            for (int i = 0; i < qs; i++) {
                TreeNode rmv = q.removeFirst();
                sum = sum + rmv.val;

                if(rmv.left != null){
                    q.addLast(rmv.left);
                }

                if(rmv.right != null){
                    q.addLast(rmv.right);
                }
            }

            ans.add((double)sum/qs);
            sum = 0;
        }

        return ans;
    }

}