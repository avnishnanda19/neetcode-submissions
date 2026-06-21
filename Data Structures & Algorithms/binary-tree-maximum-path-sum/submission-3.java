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
    Integer maxSum = null;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        getPathSum(root); 
        return maxSum;
    }
    private int  getPathSum(TreeNode root)
    {
        if(root==null) return 0;
        int val = root.val;
        int left = getPathSum(root.left); 
        int right = getPathSum(root.right);

        int maxPath = Math.max(val, Math.max(left, right)+val);
        int sum = val+((left>0) ? left : 0)+ ((right>0) ? right : 0);

        if(maxSum==null) maxSum= sum;
        else maxSum = Math.max(maxSum,sum);
        return maxPath;
    }
}
