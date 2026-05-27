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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        findDiameter(root);
        return maxDiameter;
    }
    private int findDiameter(TreeNode root)
    {
        if(root==null) return 0; 
        int leftPath =  findDiameter(root.left);
        int rightPath =  findDiameter(root.right);

        maxDiameter= Math.max(maxDiameter, leftPath+rightPath); 
        return 1+Math.max( leftPath,rightPath);
    }
}
