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

    public int averageOfSubtree(TreeNode root) {
        this.result = 0;
        int[] fromTree = dfs(root);
        return this.result;
    }

    private int[] dfs(TreeNode root)
    {
        //need sum
        //need count
        if (root==null)
        {
            return new int[]{0,0};
        }
        int[] fromLeft = dfs(root.left);
        int[] fromRight = dfs(root.right);
        int sum = fromLeft[0]+fromRight[0]+root.val;
        int count = fromLeft[1]+fromRight[1]+1;
        int ave = sum/count;
        if (root.val==ave)
        {
            this.result++;
        }
        return new int[]{sum, count};
    }
}