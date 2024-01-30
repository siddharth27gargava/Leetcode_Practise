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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> q = new LinkedList<>();

        q.addLast(root);

        while (!q.isEmpty()) {
            int qs = q.size(); //doing so that we process only those elements present at this time
            for (int i = 0; i < qs; i++) {
                TreeNode rmv = q.removeFirst();

                if (i == 0) {
                    res.add(rmv.val);
                }

                if(rmv.right != null){
                    q.addLast(rmv.right);
                }

                if (rmv.left != null) {
                    q.addLast(rmv.left);
                }
            }
        }

        return res;
    }
}