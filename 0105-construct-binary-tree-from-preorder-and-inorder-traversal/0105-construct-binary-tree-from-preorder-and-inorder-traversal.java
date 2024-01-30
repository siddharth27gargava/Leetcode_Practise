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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if (prestart > preend || instart > inend) {
            return null;
        }

        //create a root node
        TreeNode root = new TreeNode(preorder[prestart]);

        //find the root node index in inorder
        int rootIdxinInorder = calcIdx(inorder, root.val);
        //find the total distance of left tree
        int lftSTsize = rootIdxinInorder - instart;

        //recursive function to build left and right
        root.left = helper(preorder, prestart+1, prestart + lftSTsize, inorder, instart, rootIdxinInorder - 1);
        root.right = helper(preorder, prestart + lftSTsize + 1, preend, inorder, rootIdxinInorder + 1, inend);

        return root;
    }

    public int calcIdx(int[] array, int item){

        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }

        return -1;
    }
}