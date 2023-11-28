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
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Deque<TreeNode> q = new LinkedList<>();
        
        q.addLast(root);
        int level = 0;
        
        while(!q.isEmpty()){
            int qs = q.size();
            res.add(new ArrayList<>());
            for(int i = 0; i < qs; i++){
                TreeNode qans = q.removeFirst();
                res.get(level).add(qans.val);
                if(qans.left!=null){
                    q.addLast(qans.left);
                }
                
                if(qans.right!=null){
                    q.addLast(qans.right);
                }
            }
            level++;
        }
        
        return res;
    }
}