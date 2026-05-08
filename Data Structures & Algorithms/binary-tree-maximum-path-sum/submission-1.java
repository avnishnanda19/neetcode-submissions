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
    Integer maxSum=null;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxNodeValue(root);
        return maxSum;
    }

    private int maxNodeValue(TreeNode root)
    {
        int val1 = root.val;
        int val2 = (root.left==null ? 0 : maxNodeValue(root.left))+val1;
        int val3 = (root.right==null ? 0 : maxNodeValue(root.right))+val1;
        int val4 = val2+val3-val1;

        root.val=Math.max(val1, Math.max(val2, val3));
        
        if(maxSum==null)
        {
            maxSum= Math.max(val1, Math.max(val2, Math.max(val3, val4)));
        }
        else {
            maxSum= Math.max(maxSum,Math.max(val1, Math.max(val2, Math.max(val3, val4))));
        }

        return root.val;
        
    }
}
