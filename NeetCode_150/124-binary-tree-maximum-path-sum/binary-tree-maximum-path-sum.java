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

    public int maxPathSum(TreeNode root) {
        this.max = Integer.MIN_VALUE;   
        int path = getMaxPath(root);
        return this.max;
    }

    private int getMaxPath(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        int left = getMaxPath(root.left);
        int right = getMaxPath(root.right);
        //calculate sum with current node only:
        this.max = Math.max(this.max, root.val);
        //calculate sum with current node and the left subtree:
        this.max = Math.max(this.max, root.val+left);
        //calculate sum with current node and the right subtree:
        this.max = Math.max(this.max, root.val+right);
        //calculate sum with current node and both subtrees:
        this.max = Math.max(this.max, root.val+left+right);
        int includeOnlyNode = root.val;
        int includePath = Math.max(left, right)+root.val;
        return Math.max(includeOnlyNode, includePath);
    }
}