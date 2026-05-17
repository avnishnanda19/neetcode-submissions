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
    int preorderIndex;
    HashMap<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>(); 
        preorderIndex=0;
        for(int i=0;i<inorder.length;i++)
        {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0 , preorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right)
    {
        if(left>right) return null; 
        int val = preorder[preorderIndex++];
        TreeNode root =  new TreeNode(val); 
        int index = indexMap.get(val);
        root.left= buildTree(preorder, left,  index-1);
        root.right= buildTree(preorder,  index+1,  right);
        return root;
    }
}
