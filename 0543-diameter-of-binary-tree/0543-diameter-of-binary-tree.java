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

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        this.max = 0; 
        int x = depth(root);
        return this.max;
    }

    private int depth(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int diam = left+right;
        this.max = Math.max(max, diam);
        return Math.max(left, right)+1;
    }
}