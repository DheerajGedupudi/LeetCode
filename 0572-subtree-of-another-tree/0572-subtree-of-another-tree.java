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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot))
        {
            return true;
        }
        if (root==null || subRoot==null)
        {
            return false;
        }
        if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot))
        {
            return true;
        }
        return false;
    }

    private boolean isSameTree(TreeNode rootA, TreeNode rootB){
        if (rootA==null && rootB==null)
        {
            return true;
        }
        if (rootA==null || rootB==null)
        {
            return false;
        }
        if (rootA.val==rootB.val)
        {
            return isSameTree(rootA.left, rootB.left) && isSameTree(rootA.right, rootB.right);
        }
        return false;
    }
}