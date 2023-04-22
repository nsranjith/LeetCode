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
      long min=Integer.MIN_VALUE;
      long max=Integer.MAX_VALUE;
      return helper(root,min-1,max+1);  
    }
    private boolean helper(TreeNode root,long min, long max){
        if(root==null) return true;
        return (long)root.val>min && (long)root.val<max && helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
       
}