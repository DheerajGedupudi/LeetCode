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

    int minDiff;
    int best;
    int half;
    public int maxProduct(TreeNode root) {
        this.minDiff = Integer.MAX_VALUE;
        this.half = this.minDiff;
        this.best = 0;
        int sumRoot = sum(root);
        this.half = sumRoot/2;
        sumRoot = sum(root);
        long bestHalf = this.best;
        long otherHalf = (long)sumRoot-bestHalf;
        long result = bestHalf*otherHalf;
        result %= (long)Math.pow(10, 9)+7;
        return (int)result;
    }

    private int sum(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        int diff0 = Math.abs(half-left);
        int diff1 = Math.abs(half-right);
        if (diff0<this.minDiff)
        {
            this.minDiff = diff0;
            this.best = left;
        }
        if (diff1<this.minDiff)
        {
            this.minDiff = diff1;
            this.best = right;
        }
        return left+right+root.val;
    }
}