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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> q = new LinkedList<>();

        int level = 0;
        q.addLast(root);

        //start bfs
        while(!q.isEmpty()){
            int qs = q.size();
            ans.add(new ArrayList<>());
            for (int i = 0; i < qs; i++) {
                TreeNode rmv = q.removeFirst();

                ans.get(level).add(rmv.val);

                if(rmv.left!=null){
                    q.addLast(rmv.left);
                }

                if(rmv.right!=null) {
                    q.addLast(rmv.right);
                }
            }
            level++;
        }

        return ans;
    }
}