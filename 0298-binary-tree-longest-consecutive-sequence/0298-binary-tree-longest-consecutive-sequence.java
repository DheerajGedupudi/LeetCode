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

    private int result;

    public int longestConsecutive(TreeNode root) {   
        this.result = 1;
        helper(root, 1);
        return this.result;
    }

    private void helper(TreeNode root, int count)
    {
        if (root==null)
        {
            return;
        }
        if (root.left!=null && root.val+1==root.left.val)
        {
            this.result = Math.max(this.result, count+1);
            helper(root.left, count+1);
        }
        else
        {
            helper(root.left, 1);
        }
        if (root.right!=null && root.val+1==root.right.val)
        {
            this.result = Math.max(this.result, count+1);
            helper(root.right, count+1);
        }
        else
        {
            helper(root.right, 1);
        }
    }

}