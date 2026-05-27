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
    int count ;
    public int goodNodes(TreeNode root) {
        if(root==null) return 0; 
        count=1;
        findGoodNodes(root.left, root.val); 
        findGoodNodes(root.right, root.val);
        return count;
    }
    private void findGoodNodes(TreeNode root , int maxVal)
    {
        if(root==null) return ;
        if(root.val>=maxVal)
        {
            count++; 
            maxVal = root.val;
        }
        findGoodNodes(root.left,maxVal); 
        findGoodNodes(root.right, maxVal);
    }
}
