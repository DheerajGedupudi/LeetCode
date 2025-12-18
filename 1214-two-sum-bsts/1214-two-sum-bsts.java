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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        //do bs on each node of root1
        if (root1==null)
        {
            return false;
        }
        int required = target-root1.val;
        if (bs(root2, required))
        {
            return true;
        }
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    private boolean bs(TreeNode root, int target)
    {
        if (root==null)
        {
            return false;
        }
        if (root.val==target)
        {
            return true;
        }
        if (root.val<target)
        {
            return bs(root.right, target);
        }
        else
        {
            return bs(root.left, target);
        }
    }
}