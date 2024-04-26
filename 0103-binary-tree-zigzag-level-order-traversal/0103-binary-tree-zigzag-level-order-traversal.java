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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //do a normal bfs
        //reverse the elements for odd lists
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        //bfs starts
        while (!q.isEmpty()) {
            int qs = q.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < qs; i++) {
                TreeNode rmv = q.removeFirst();
                res.get(level).add(rmv.val);

                if (rmv.left != null) {
                    q.addLast(rmv.left);
                }

                if (rmv.right != null) {
                    q.addLast(rmv.right);
                }
            }
            level++;
        }

        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(res.get(i));
            }
        }

        return res;
    }
}