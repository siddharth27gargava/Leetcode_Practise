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
        List<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        Deque<TreeNode> q = new LinkedList<>();
        
        q.addLast(root);
        
        while(!q.isEmpty()){
            int qs = q.size();
            for(int i = 0; i < qs; i++){
                
                TreeNode qans = q.removeFirst();
                
                if(i == 0){
                    ans.add(qans.val);
                }
                
                if(qans.right!=null){
                    q.addLast(qans.right);
                }
                
                if(qans.left!=null){
                    q.addLast(qans.left);
                }
            }
        }
        
        return ans;
    }
}