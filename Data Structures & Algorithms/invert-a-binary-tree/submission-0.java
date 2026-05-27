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
    public TreeNode invertTree(TreeNode root) {
        if(root== null) return root; 
        TreeNode leftSide = invertTree(root.left);
        TreeNode rightSide =  invertTree(root.right); 
        root.left = rightSide; 
        root.right = leftSide;
        return root;
    }
}
