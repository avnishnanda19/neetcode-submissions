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
    int smallrank; 
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.smallrank= k;
        this.result =0; 
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root)
    {   
        if(root==null) return;
        inorder(root.left);
        smallrank--;
        if(smallrank==0) {
            result=root.val;
            return;
        }
        inorder(root.right);
    }
}
