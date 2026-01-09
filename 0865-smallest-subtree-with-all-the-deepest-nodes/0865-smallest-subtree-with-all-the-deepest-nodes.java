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

    private TreeNode result;
    private int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        this.result = null;    
        this.maxDepth = -1;
        int x = getDepth(root, 0);
        return this.result;
    }

    private int getDepth(TreeNode root, int depth)
    {
        if (root==null)
        {
            return depth;
        }
        int left = getDepth(root.left, depth+1);
        int right = getDepth(root.right, depth+1);
        if (left==right && left>=this.maxDepth)
        {
            this.maxDepth = left;
            this.result = root;
        }
        return Math.max(left, right);
    }
}