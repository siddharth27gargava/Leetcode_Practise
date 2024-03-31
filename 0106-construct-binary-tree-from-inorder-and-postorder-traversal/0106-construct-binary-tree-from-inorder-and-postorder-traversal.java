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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIdxinInorder = calcIdx(inorder, postorder[postEnd]);

        int lstdist = rootIdxinInorder - inStart;

        root.left = helper(inorder, inStart, rootIdxinInorder - 1, postorder, postStart, postStart + lstdist - 1);
        root.right = helper(inorder, rootIdxinInorder + 1, inEnd, postorder, postStart + lstdist, postEnd - 1);

        return root;
    }

    public int calcIdx(int[] arr, int item){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == item){
                return i;
            }
        }

        return -1;
    }
}