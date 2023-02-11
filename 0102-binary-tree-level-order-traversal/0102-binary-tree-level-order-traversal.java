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
      
       
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
         if(root == null){
            return ans;
        }
      
        Queue<TreeNode> q = new LinkedList();
        
        q.add(root);
        int level = 0;
        
        
        
        while(!q.isEmpty()){
        ans.add(new ArrayList<>());    
        int level_len = q.size();
            for(int i = 0; i < level_len; i++){
                TreeNode rv = q.poll();
                ans.get(level).add(rv.val);
                
                if(rv.left!=null){
                    q.add(rv.left);
                }
                
                if(rv.right!=null){
                    q.add(rv.right);
                }
            }
            
            level++;
        }
        
        return ans;
    }
}