

import com.sun.source.tree.Tree;

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

        q.addLast(root);

        int level = 0;

        while (!q.isEmpty()) {
            int qs = q.size(); //reason why we run loop at this is because we want to process only those elements which are in the q at this time
            ans.add(new ArrayList<>());
            for (int i = 0; i < qs; i++) {
                TreeNode rmv = q.removeFirst();
                //very improtant that you forget
                ans.get(level).add(rmv.val);

                if (rmv.left != null) {
                    q.addLast(rmv.left);
                }
                if (rmv.right != null) {
                    q.addLast(rmv.right);
                }
            }
            level++;
        }

        return ans;
    }
}