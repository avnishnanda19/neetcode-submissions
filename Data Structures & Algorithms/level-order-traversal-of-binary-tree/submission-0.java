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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); 

        Queue<TreeNode> q = new LinkedList<>(); 
        if(root!=null)q.offer(root);
        int count = 1; 
        while(!q.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<count;i++)
            {
                TreeNode p = q.poll(); 
                if(p!=null) list.add(p.val);
                if(p.left!=null)
                {
                    q.offer(p.left); 
                }
                if(p.right!=null)
                {
                    q.offer(p.right); 
                }
            }
            count =  q.size();
            result.add(list);
        }
        return result;
    }
}
