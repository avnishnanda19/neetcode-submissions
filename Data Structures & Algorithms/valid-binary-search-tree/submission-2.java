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
        boolean validateBSTLeft = validateBSTNode(root.left, -1001, root.val);
        boolean validateBSTright = validateBSTNode(root.right , root.val, 1001);

        return validateBSTLeft && validateBSTright;
    }

    private boolean validateBSTNode(TreeNode root, int minVal,int maxVal)
    {
        if(root==null) return true; 
    
        if(!(minVal<root.val && root.val<maxVal)) return false;
        
        boolean validateBSTLeft = validateBSTNode(root.left, minVal, root.val);
        boolean validateBSTright = validateBSTNode(root.right, root.val ,maxVal);
        
        return validateBSTLeft && validateBSTright;

    }

}
