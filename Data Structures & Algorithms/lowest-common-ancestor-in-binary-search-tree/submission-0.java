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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p , q); 

        return lca;
    }
    public void traversal(TreeNode root, TreeNode p , TreeNode q)
    {
        if(root==null) return;
        if(root.val==p.val || root.val == q.val) {
            lca = root;
            return;
        } 

        if((p.val>root.val && q.val<root.val) || (q.val>root.val && p.val<root.val)) {
            lca = root;
            return;
        } 
        if(p.val>root.val)
            traversal(root.right , p, q);
        else 
            traversal(root.left , p, q);
    }
}
