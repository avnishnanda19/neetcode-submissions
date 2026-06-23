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
    Map<Integer, Integer> inOrderIndex ; 
    int index ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderIndex =  new HashMap<>(); 
        index = 0;

        for(int i=0;i<inorder.length ;i++)
        {
            inOrderIndex.put(inorder[i],i);
        }

        return createTree(preorder, 0 , preorder.length-1);
    }

    private TreeNode createTree(int[] preorder, int left, int right)
    {
        if(left>right) return null; 

        int val = preorder[index++]; 
        TreeNode root = new TreeNode(val);
        int i = inOrderIndex.get(val); 
        root.left = createTree(preorder, left , i-1);
        root.right = createTree(preorder, i+1 , right);
        return root;
    }
}
