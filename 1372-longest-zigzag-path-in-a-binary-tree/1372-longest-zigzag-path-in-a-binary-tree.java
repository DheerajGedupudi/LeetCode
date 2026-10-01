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
    public int longestZigZag(TreeNode root) {
        this.result = 0;
        int[] arr = helper(root);
        return this.result;
    }

    private int[] helper(TreeNode root) //leftlength, rightlength
    {
        if (root==null)
        {
            return new int[0];
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int leftLength = 0;
        if (left.length>0)
        {
            leftLength = left[1]+1;
        }
        int rightLength = 0;
        if (right.length>0)
        {
            rightLength = right[0]+1;
        }
        // System.out.println(leftLength+" "+rightLength);
        this.result = Math.max(this.result, leftLength);
        this.result = Math.max(this.result, rightLength);
        return new int[]{leftLength, rightLength};
    }
}