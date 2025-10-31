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

    private int grandSum;

    public int sumNumbers(TreeNode root) {
        this.grandSum = 0;
        dfs(root, 0);
        return this.grandSum;
    }

    private void dfs(TreeNode root, int num)
    {
        // System.out.println(root.val+" -> "+num);
        if (root.left==null && root.right==null)
        {
            this.grandSum += (num*10)+root.val;
            return;
        }
        if (root.left!=null)
        {
            dfs(root.left, (num*10)+root.val);
        }
        if (root.right!=null)
        {
            dfs(root.right, (num*10)+root.val);
        }

    }
}