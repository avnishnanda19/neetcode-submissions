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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean left = isBST(root.left, -1001, root.val);
        boolean right = isBST(root.right,  root.val, 1001); 
        return left && right;
    }
    private boolean isBST(TreeNode root, int min, int max){
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;
        boolean left = isBST(root.left, min, root.val);
        boolean right = isBST(root.right,  root.val, max); 
        return left && right;
    }
}
